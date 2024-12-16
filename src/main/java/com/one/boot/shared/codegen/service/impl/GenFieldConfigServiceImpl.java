package com.one.boot.shared.codegen.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.one.boot.shared.codegen.mapper.GenFieldConfigMapper;
import com.one.boot.shared.codegen.model.entity.GenFieldConfig;
import com.one.boot.shared.codegen.service.GenFieldConfigService;
import com.one.boot.shared.codegen.mapper.GenFieldConfigMapper;
import com.one.boot.shared.codegen.model.entity.GenFieldConfig;
import com.one.boot.shared.codegen.service.GenFieldConfigService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 代码生成字段配置服务实现类
 *
 * @author maintell
 * @since 2.10.0
 */
@Service
@RequiredArgsConstructor
public class GenFieldConfigServiceImpl extends ServiceImpl<GenFieldConfigMapper, GenFieldConfig> implements GenFieldConfigService {


}
