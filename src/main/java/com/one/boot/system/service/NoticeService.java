package com.one.boot.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.one.boot.system.model.entity.Notice;
import com.one.boot.system.model.form.NoticeForm;
import com.one.boot.system.model.query.NoticePageQuery;
import com.one.boot.system.model.vo.NoticeDetailVO;
import com.one.boot.system.model.vo.NoticePageVO;
import com.one.boot.system.model.vo.UserNoticePageVO;
import com.one.boot.system.model.entity.Notice;
import com.one.boot.system.model.form.NoticeForm;
import com.one.boot.system.model.query.NoticePageQuery;
import com.one.boot.system.model.vo.NoticePageVO;
import com.one.boot.system.model.vo.UserNoticePageVO;
import com.one.boot.system.model.vo.NoticeDetailVO;

/**
 * 通知公告服务类
 *
 * @author maintell
 * @since 2024-08-27 10:31
 */
public interface NoticeService extends IService<Notice> {

    /**
     * 通知公告分页列表
     *
     * @return 通知公告分页列表
     */
    IPage<NoticePageVO> getNoticePage(NoticePageQuery queryParams);

    /**
     * 获取通知公告表单数据
     *
     * @param id 通知公告ID
     * @return 通知公告表单对象
     */
    NoticeForm getNoticeFormData(Long id);

    /**
     * 新增通知公告
     *
     * @param formData 通知公告表单对象
     * @return 是否新增成功
     */
    boolean saveNotice(NoticeForm formData);

    /**
     * 修改通知公告
     *
     * @param id       通知公告ID
     * @param formData 通知公告表单对象
     * @return 是否修改成功
     */
    boolean updateNotice(Long id, NoticeForm formData);

    /**
     * 删除通知公告
     *
     * @param ids 通知公告ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    boolean deleteNotices(String ids);

    /**
     * 发布通知公告
     *
     * @param id 通知公告ID
     * @return 是否发布成功
     */
    boolean publishNotice(Long id);

    /**
     * 撤回通知公告
     *
     * @param id 通知公告ID
     * @return 是否撤回成功
     */
    boolean revokeNotice(Long id);

    /**
     * 阅读获取通知公告详情
     *
     * @param id 通知公告ID
     * @return 通知公告详情
     */
    NoticeDetailVO getNoticeDetail(Long id);

    /**
     * 获取我的通知公告分页列表
     *
     * @param queryParams 查询参数
     * @return 通知公告分页列表
     */
    IPage<UserNoticePageVO> getMyNoticePage(NoticePageQuery queryParams);
}
