package com.one.boot.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.one.boot.system.model.entity.Dict;
import com.one.boot.system.model.form.DictForm;
import com.one.boot.system.model.query.DictPageQuery;
import com.one.boot.system.model.vo.DictPageVO;
import com.one.boot.system.model.vo.DictVO;
import com.one.boot.common.model.Option;
import com.one.boot.system.model.entity.Dict;
import com.one.boot.system.model.form.DictForm;
import com.one.boot.system.model.query.DictPageQuery;
import com.one.boot.system.model.vo.DictPageVO;
import com.one.boot.system.model.vo.DictVO;

import java.util.List;

/**
 * 字典业务接口
 *
 * @author maintell
 * @since 2022/10/12
 */
public interface DictService extends IService<Dict> {

    /**
     * 字典分页列表
     *
     * @param queryParams 分页查询对象
     * @return
     */
    Page<DictPageVO> getDictPage(DictPageQuery queryParams);


    /**
     * 获取字典表单详情
     *
     * @param id 字典ID
     * @return
     */
    DictForm getDictForm(Long id);


    /**
     * 新增字典
     *
     * @param dictForm 字典表单
     * @return
     */
    boolean saveDict(DictForm dictForm);


    /**
     * 修改字典
     *
     * @param id     字典ID
     * @param dictForm 字典表单
     * @return
     */
    boolean updateDict(Long id, DictForm dictForm);

    /**
     * 删除字典
     *
     * @param idsStr 字典ID，多个以英文逗号(,)分割
     * @return
     */
    void deleteDictByIds(String idsStr);


    /**
     * 获取字典列表
     *
     * @return
     */
    List<DictVO> getAllDictWithData();
}
