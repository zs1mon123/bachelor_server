package com.one.boot.system.model.form;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 重置密码表单
 *
 * @author maintell
 * @since 2024/8/13
 */
@Schema(description = "重置密码表单")
@Data
public class PasswordResetForm {

    @Schema(description = "用户ID")
    private Long userId;

    @Schema(description = "密码")
    private String password;


}
