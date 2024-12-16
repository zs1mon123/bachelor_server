package com.one.boot.system.model.form;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 修改手机表单
 *
 * @author maintell
 * @since 2024/8/19
 */
@Schema(description = "修改手机表单")
@Data
public class MobileBindingForm {

    @Schema(description = "原密码")
    private String mobile;

    @Schema(description = "验证码")
    private String code;

}
