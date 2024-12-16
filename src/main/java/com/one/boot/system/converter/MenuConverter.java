package com.one.boot.system.converter;

import com.one.boot.system.model.entity.Menu;
import com.one.boot.system.model.form.MenuForm;
import com.one.boot.system.model.vo.MenuVO;
import com.one.boot.system.model.entity.Menu;
import com.one.boot.system.model.vo.MenuVO;
import com.one.boot.system.model.form.MenuForm;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * 菜单对象转换器
 *
 * @author maintell
 * @since 2024/5/26
 */
@Mapper(componentModel = "spring")
public interface MenuConverter {

    MenuVO toVo(Menu entity);

    @Mapping(target = "params", ignore = true)
    MenuForm toForm(Menu entity);

    @Mapping(target = "params", ignore = true)
    Menu toEntity(MenuForm menuForm);

}