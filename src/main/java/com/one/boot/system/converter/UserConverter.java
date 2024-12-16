package com.one.boot.system.converter;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.one.boot.system.model.bo.UserBO;
import com.one.boot.system.model.dto.UserImportDTO;
import com.one.boot.system.model.entity.User;
import com.one.boot.system.model.form.UserForm;
import com.one.boot.system.model.form.UserProfileForm;
import com.one.boot.system.model.vo.UserInfoVO;
import com.one.boot.system.model.vo.UserPageVO;
import com.one.boot.system.model.vo.UserProfileVO;
import com.one.boot.system.model.entity.User;
import com.one.boot.system.model.vo.UserInfoVO;
import com.one.boot.system.model.vo.UserPageVO;
import com.one.boot.system.model.vo.UserProfileVO;
import com.one.boot.system.model.bo.UserBO;
import com.one.boot.system.model.form.UserForm;
import com.one.boot.system.model.dto.UserImportDTO;
import com.one.boot.system.model.form.UserProfileForm;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * 用户对象转换器
 *
 * @author maintell
 * @since 2022/6/8
 */
@Mapper(componentModel = "spring")
public interface UserConverter {

    @Mappings({
            @Mapping(target = "genderLabel", expression = "java(com.one.boot.common.base.IBaseEnum.getLabelByValue(bo.getGender(), com.one.boot.system.enums.GenderEnum.class))")
    })
    UserPageVO toPageVo(UserBO bo);

    Page<UserPageVO> toPageVo(Page<UserBO> bo);

    UserForm toForm(User entity);

    @InheritInverseConfiguration(name = "toForm")
    User toEntity(UserForm entity);

    @Mappings({
            @Mapping(target = "userId", source = "id")
    })
    UserInfoVO toUserInfoVo(User entity);

    User toEntity(UserImportDTO vo);


    UserProfileVO toProfileVO(UserBO bo);

    User toEntity(UserProfileForm formData);
}
