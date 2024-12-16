package com.one.boot.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.one.boot.system.model.entity.Dict;
import com.one.boot.system.model.query.DictPageQuery;
import com.one.boot.system.model.vo.DictPageVO;
import com.one.boot.system.model.vo.DictVO;
import com.one.boot.common.model.Option;
import com.one.boot.system.model.entity.Dict;
import com.one.boot.system.model.query.DictPageQuery;
import com.one.boot.system.model.vo.DictPageVO;
import com.one.boot.system.model.vo.DictVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 字典 访问层
 *
 * @author maintell
 * @since 2.9.0
 */
@Mapper
public interface DictMapper extends BaseMapper<Dict> {

    /**
     * 字典分页列表
     *
     * @param page 分页参数
     * @param queryParams 查询参数
     * @return
     */
    Page<DictPageVO> getDictPage(Page<DictPageVO> page, DictPageQuery queryParams);

    /**
     * 获取所有字典和字典数据
     *
     * @return
     */
    List<DictVO> getAllDictWithData();
}




