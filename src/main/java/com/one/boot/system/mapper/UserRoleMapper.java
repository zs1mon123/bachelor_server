package com.one.boot.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.one.boot.system.model.entity.UserRole;
import com.one.boot.system.model.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户角色访问层
 *
 * @author maintell
 * @since 2022/1/15
 */
@Mapper
public interface UserRoleMapper extends BaseMapper<UserRole> {

    /**
     * 获取角色绑定的用户数
     *
     * @param roleId 角色ID
     */
    int countUsersForRole(Long roleId);
}