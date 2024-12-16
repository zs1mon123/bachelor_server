package com.one.boot.core.filter;

import com.one.boot.common.util.IPUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

/**
 * 请求日志打印过滤器
 *
 * @author maintell
 * @since 2023/03/03
 */
@Configuration
@Slf4j
public class RequestLogFilter extends CommonsRequestLoggingFilter {

    @Override
    protected boolean shouldLog(HttpServletRequest request) {
        // 设置日志输出级别，默认debug
        return this.logger.isInfoEnabled();
    }

    @Override
    protected void beforeRequest(HttpServletRequest request, String message) {
        String requestURI = request.getRequestURI();
        String ip = IPUtils.getIpAddr(request);
        log.info("request,ip:{}, uri: {}", ip, requestURI);
        super.beforeRequest(request, message);
    }

    @Override
    protected void afterRequest(HttpServletRequest request, String message) {
        super.afterRequest(request, message);
    }

}
