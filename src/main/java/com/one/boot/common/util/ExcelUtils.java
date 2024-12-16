package com.one.boot.common.util;

import com.alibaba.excel.EasyExcel;
import com.one.boot.common.base.BaseAnalysisEventListener;

import java.io.InputStream;

/**
 * Excel 工具类
 *
 * @author maintell
 * @since 2023/03/01
 */
public class ExcelUtils {

    public static <T> String importExcel(InputStream is, Class clazz, BaseAnalysisEventListener<T> listener) {
        EasyExcel.read(is, clazz, listener).sheet().doRead();
        return listener.getMsg();
    }
}
