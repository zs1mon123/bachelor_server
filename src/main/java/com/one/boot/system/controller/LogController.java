package com.one.boot.system.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.one.boot.common.result.PageResult;
import com.one.boot.common.result.Result;
import com.one.boot.system.model.query.LogPageQuery;
import com.one.boot.system.model.vo.LogPageVO;
import com.one.boot.system.model.vo.VisitStatsVO;
import com.one.boot.system.model.vo.VisitTrendVO;
import com.one.boot.system.service.LogService;
import com.one.boot.common.result.PageResult;
import com.one.boot.common.result.Result;
import com.one.boot.system.model.query.LogPageQuery;
import com.one.boot.system.model.vo.LogPageVO;
import com.one.boot.system.model.vo.VisitStatsVO;
import com.one.boot.system.model.vo.VisitTrendVO;
import com.one.boot.system.service.LogService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


/**
 * 日志控制层
 *
 * @author maintell
 * @since 2.10.0
 */
@Tag(name = "09.日志接口")
@RestController
@RequestMapping("/api/v1/logs")
@RequiredArgsConstructor
public class LogController {

    private final LogService logService;

    @Operation(summary = "日志分页列表")
    @GetMapping("/page")
    public PageResult<LogPageVO> getLogPage(
             LogPageQuery queryParams
    ) {
        Page<LogPageVO> result = logService.getLogPage(queryParams);
        return PageResult.success(result);
    }

    @Operation(summary = "获取访问趋势")
    @GetMapping("/visit-trend")
    public Result<VisitTrendVO> getVisitTrend(
            @Parameter(description = "开始时间", example = "yyyy-MM-dd") @RequestParam String startDate,
            @Parameter(description = "结束时间", example = "yyyy-MM-dd") @RequestParam String endDate
    ) {
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        VisitTrendVO data = logService.getVisitTrend(start, end);
        return Result.success(data);
    }

    @Operation(summary = "获取统计数据")
    @GetMapping("/visit-stats")
    public Result<List<VisitStatsVO>> getVisitStats() {
        List<VisitStatsVO> list = logService.getVisitStats();
        return Result.success(list);
    }

}
