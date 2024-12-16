package com.one.boot.system.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.one.boot.common.annotation.Log;
import com.one.boot.common.annotation.RepeatSubmit;
import com.one.boot.common.enums.LogModuleEnum;
import com.one.boot.common.result.PageResult;
import com.one.boot.common.result.Result;
import com.one.boot.system.model.form.DictForm;
import com.one.boot.system.model.query.DictPageQuery;
import com.one.boot.system.model.vo.DictPageVO;
import com.one.boot.system.model.vo.DictVO;
import com.one.boot.system.service.DictService;
import com.one.boot.common.model.Option;
import com.one.boot.common.result.PageResult;
import com.one.boot.common.result.Result;
import com.one.boot.common.enums.LogModuleEnum;
import com.one.boot.system.model.query.DictPageQuery;
import com.one.boot.system.model.vo.DictPageVO;
import com.one.boot.common.annotation.RepeatSubmit;
import com.one.boot.system.model.form.DictForm;
import com.one.boot.common.annotation.Log;
import com.one.boot.system.model.vo.DictVO;
import com.one.boot.system.service.DictService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 字典控制层
 *
 * @author maintell
 * @since 2.9.0
 */
@Tag(name = "06.字典接口")
@RestController
@RequestMapping("/api/v1/dict")
@RequiredArgsConstructor
public class DictController {

    private final DictService dictService;

    @Operation(summary = "字典分页列表")
    @GetMapping("/page")
    @Log( value = "字典分页列表",module = LogModuleEnum.DICT)
    public PageResult<DictPageVO> getDictPage(
            DictPageQuery queryParams
    ) {
        Page<DictPageVO> result = dictService.getDictPage(queryParams);
        return PageResult.success(result);
    }

    @Operation(summary = "字典列表")
    @GetMapping("/list")
    public Result<List<DictVO>> getAllDictWithData() {
        List<DictVO> list = dictService.getAllDictWithData();
        return Result.success(list);
    }

    @Operation(summary = "字典表单")
    @GetMapping("/{id}/form")
    public Result<DictForm> getDictForm(
            @Parameter(description = "字典ID") @PathVariable Long id
    ) {
        DictForm formData = dictService.getDictForm(id);
        return Result.success(formData);
    }

    @Operation(summary = "新增字典")
    @PostMapping
    @PreAuthorize("@ss.hasPerm('sys:dict:add')")
    @RepeatSubmit
    public Result<?> saveDict(@Valid @RequestBody DictForm formData) {
        boolean result = dictService.saveDict(formData);
        return Result.judge(result);
    }

    @Operation(summary = "修改字典")
    @PutMapping("/{id}")
    @PreAuthorize("@ss.hasPerm('sys:dict:edit')")
    public Result<?> updateDict(
            @PathVariable Long id,
            @RequestBody DictForm DictForm
    ) {
        boolean status = dictService.updateDict(id, DictForm);
        return Result.judge(status);
    }

    @Operation(summary = "删除字典")
    @DeleteMapping("/{ids}")
    @PreAuthorize("@ss.hasPerm('sys:dict:delete')")
    public Result<?> deleteDictionaries(
            @Parameter(description = "字典ID，多个以英文逗号(,)拼接") @PathVariable String ids
    ) {
        dictService.deleteDictByIds(ids);
        return Result.success();
    }







}
