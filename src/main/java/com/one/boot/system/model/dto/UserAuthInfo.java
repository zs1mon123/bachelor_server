package com.one.boot.system.model.dto;

import lombok.Data;

import java.util.Set;

/**
 * 用户认证信息
 *
 * @author maintell
 * @since 2022/10/22
 *
 */
@Data
public class UserAuthInfo {

    private Long userId;

    private String username;

    private String nickname;

    private Long deptId;

    private String password;

    private Integer status;

    private Set<String> roles;

    private Set<String> perms;

    private Integer dataScope;

}
