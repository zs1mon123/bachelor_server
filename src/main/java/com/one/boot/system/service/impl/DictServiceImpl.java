package com.one.boot.system.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.one.boot.common.exception.BusinessException;
import com.one.boot.system.model.entity.Dict;
import com.one.boot.system.model.entity.DictData;
import com.one.boot.system.model.form.DictForm;
import com.one.boot.system.model.query.DictPageQuery;
import com.one.boot.system.model.vo.DictPageVO;
import com.one.boot.system.model.vo.DictVO;
import com.one.boot.common.exception.BusinessException;
import com.one.boot.system.converter.DictConverter;
import com.one.boot.system.converter.DictDataConverter;
import com.one.boot.system.mapper.DictMapper;
import com.one.boot.system.model.entity.Dict;
import com.one.boot.system.model.entity.DictData;
import com.one.boot.system.model.form.DictForm;
import com.one.boot.system.model.query.DictPageQuery;
import com.one.boot.system.model.vo.DictPageVO;
import com.one.boot.common.model.Option;
import com.one.boot.system.model.vo.DictVO;
import com.one.boot.system.service.DictDataService;
import com.one.boot.system.service.DictService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * 数据字典业务实现类
 *
 * @author maintell
 * @since 2022/10/12
 */
@Service
@RequiredArgsConstructor
public class DictServiceImpl extends ServiceImpl<DictMapper, Dict> implements DictService {

    private final DictDataService dictDataService;
    private final DictConverter dictConverter;
    private final DictDataConverter dictDataConverter;

    /**
     * 字典分页列表
     *
     * @param queryParams 分页查询对象
     */
    @Override
    public Page<DictPageVO> getDictPage(DictPageQuery queryParams) {
        // 查询参数
        int pageNum = queryParams.getPageNum();
        int pageSize = queryParams.getPageSize();

        // 查询数据
        return this.baseMapper.getDictPage(new Page<>(pageNum, pageSize), queryParams);
    }

    /**
     * 新增字典
     *
     * @param dictForm 字典表单数据
     */
    @Override
    public boolean saveDict(DictForm dictForm) {
        // 保存字典
        Dict entity = dictConverter.toEntity(dictForm);

        // 校验 code 是否唯一
        String dictCode = entity.getDictCode();

        long count = this.count(new LambdaQueryWrapper<Dict>()
                .eq(Dict::getDictCode, dictCode)
        );
        Assert.isTrue(count == 0, "字典编码已存在");

        return this.save(entity);
    }


    /**
     * 获取字典表单详情
     *
     * @param id 字典ID
     */
    @Override
    public DictForm getDictForm(Long id) {
        // 获取字典
        Dict entity = this.getById(id);
        if(entity==null){
            throw new BusinessException("字典不存在");
        }
        return dictConverter.toForm(entity);
    }

    /**
     * 修改字典
     *
     * @param id       字典ID
     * @param dictForm 字典表单
     */
    @Override
    public boolean updateDict(Long id, DictForm dictForm) {
        // 更新字典
        Dict entity = dictConverter.toEntity(dictForm);

        // 校验 code 是否唯一
        String dictCode = entity.getDictCode();
        long count = this.count(new LambdaQueryWrapper<Dict>()
                .eq(Dict::getDictCode, dictCode)
                .ne(Dict::getId, id)
        );
        if(count>0){
            throw new BusinessException("字典编码已存在");
        }

        return this.updateById(entity);
    }

    /**
     * 删除字典
     *
     * @param ids 字典ID，多个以英文逗号(,)分割
     */
    @Override
    @Transactional
    public void deleteDictByIds(String ids) {

        Assert.isTrue(StrUtil.isNotBlank(ids), "请选择需要删除的字典");

        List<String> idList = Arrays.stream(ids.split(","))
                .toList();

        for (String id : idList) {
            Dict dict = this.getById(id);
            if (dict != null) {
                boolean removeResult = this.removeById(id);
                // 删除字典下的字典项
                if (removeResult) {
                    dictDataService.remove(
                            new LambdaQueryWrapper<DictData>()
                                    .eq(DictData::getDictCode, dict.getDictCode())
                    );
                }

            }
        }
    }

    /**
     * 获取所有字典和字典数据
     */
    @Override
    public List<DictVO>  getAllDictWithData() {
        return this.baseMapper.getAllDictWithData();
    }
}




