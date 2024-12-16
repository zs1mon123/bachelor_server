package com.one.boot.system.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.one.boot.common.base.BaseEntity;
import com.one.boot.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 字典实体
 *
 * @author maintell
 * @since 2022/12/17
 */
@EqualsAndHashCode(callSuper = false)
@TableName("sys_dict")
@Data
public class Dict extends BaseEntity {

    /**
     * 字典编码
     */
    private String dictCode;

    /**
     * 字典名称
     */
    private String name;


    /**
     * 状态（1：启用, 0：停用）
     */
    private Integer status;

    /**
     * 备注
     */
    private String remark;

    /**
     * 逻辑删除标识(0-未删除 1-已删除)
     */
    private Integer isDeleted;

}