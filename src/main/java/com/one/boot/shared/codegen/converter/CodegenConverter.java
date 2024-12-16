package com.one.boot.shared.codegen.converter;

import com.one.boot.shared.codegen.model.entity.GenConfig;
import com.one.boot.shared.codegen.model.entity.GenFieldConfig;
import com.one.boot.shared.codegen.model.form.GenConfigForm;
import com.one.boot.shared.codegen.model.entity.GenConfig;
import com.one.boot.shared.codegen.model.entity.GenFieldConfig;
import com.one.boot.shared.codegen.model.form.GenConfigForm;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * 代码生成配置转换器
 *
 * @author maintell
 * @since 2.10.0
 */
@Mapper(componentModel = "spring")
public interface CodegenConverter {

    @Mapping(source = "genConfig.tableName", target = "tableName")
    @Mapping(source = "genConfig.businessName", target = "businessName")
    @Mapping(source = "genConfig.moduleName", target = "moduleName")
    @Mapping(source = "genConfig.packageName", target = "packageName")
    @Mapping(source = "genConfig.entityName", target = "entityName")
    @Mapping(source = "genConfig.author", target = "author")
    @Mapping(source = "fieldConfigs", target = "fieldConfigs")
    GenConfigForm toGenConfigForm(GenConfig genConfig, List<GenFieldConfig> fieldConfigs);

    List<GenConfigForm.FieldConfig> toGenFieldConfigForm(List<GenFieldConfig> fieldConfigs);

    GenConfigForm.FieldConfig toGenFieldConfigForm(GenFieldConfig genFieldConfig);

    GenConfig toGenConfig(GenConfigForm formData);

    List<GenFieldConfig> toGenFieldConfig(List<GenConfigForm.FieldConfig> fieldConfigs);

    GenFieldConfig toGenFieldConfig(GenConfigForm.FieldConfig fieldConfig);

}