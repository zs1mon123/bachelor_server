package com.one.boot.system.enums;

import com.one.boot.common.base.IBaseEnum;
import com.one.boot.common.base.IBaseEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

/**
 * 通知目标类型枚举
 *
 * @author maintell
 * @since 2022/10/14
 */
@Getter
@Schema(enumAsRef = true)
public enum NoticeTargetTypeEnum implements IBaseEnum<Integer> {

    ALL(1, "全体"),
    SPECIFIED(2, "指定");


    private final Integer value;

    private final String label;

    NoticeTargetTypeEnum(Integer value, String label) {
        this.value = value;
        this.label = label;
    }
}
