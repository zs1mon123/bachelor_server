package com.one.boot.system.converter;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.one.boot.common.model.Option;
import com.one.boot.system.model.entity.Role;
import com.one.boot.system.model.form.RoleForm;
import com.one.boot.system.model.vo.RolePageVO;
import com.one.boot.system.model.entity.Role;
import com.one.boot.system.model.vo.RolePageVO;
import com.one.boot.common.model.Option;
import com.one.boot.system.model.form.RoleForm;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

/**
 * 角色对象转换器
 *
 * @author maintell
 * @since 2022/5/29
 */
@Mapper(componentModel = "spring")
public interface RoleConverter {

    Page<RolePageVO> toPageVo(Page<Role> page);

    @Mappings({
            @Mapping(target = "value", source = "id"),
            @Mapping(target = "label", source = "name")
    })
    Option<Long> entity2Option(Role role);

    List<Option<Long>> entities2Options(List<Role> roles);

    Role toEntity(RoleForm roleForm);

    RoleForm toForm(Role entity);
}