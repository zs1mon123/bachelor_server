package com.one.boot.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.one.boot.system.model.bo.NoticeBO;
import com.one.boot.system.model.entity.Notice;
import com.one.boot.system.model.query.NoticePageQuery;
import com.one.boot.system.model.vo.NoticePageVO;
import com.one.boot.system.model.bo.NoticeBO;
import com.one.boot.system.model.entity.Notice;
import com.one.boot.system.model.query.NoticePageQuery;
import com.one.boot.system.model.vo.NoticePageVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 通知公告Mapper接口
 *
 * @author maintell
 * @since 2024-08-27 10:31
 */
@Mapper
public interface NoticeMapper extends BaseMapper<Notice> {

    /**
     * 获取通知公告分页数据
     *
     * @param page 分页对象
     * @param queryParams 查询参数
     * @return 通知公告分页数据
     */
    Page<NoticeBO> getNoticePage(Page<NoticePageVO> page, NoticePageQuery queryParams);

    /**
     * 获取阅读时通知公告详情
     *
     * @param id 通知公告ID
     * @return 通知公告详情
     */
    NoticeBO getNoticeDetail(@Param("id") Long id);
}
