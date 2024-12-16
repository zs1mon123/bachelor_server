package com.one.boot.system.converter;

import com.one.boot.system.model.entity.Dept;
import com.one.boot.system.model.form.DeptForm;
import com.one.boot.system.model.vo.DeptVO;
import com.one.boot.system.model.entity.Dept;
import com.one.boot.system.model.vo.DeptVO;
import com.one.boot.system.model.form.DeptForm;
import org.mapstruct.Mapper;

/**
 * 部门对象转换器
 *
 * @author maintell
 * @since 2022/7/29
 */
@Mapper(componentModel = "spring")
public interface DeptConverter {

    DeptForm toForm(Dept entity);
    
    DeptVO toVo(Dept entity);

    Dept toEntity(DeptForm deptForm);

}