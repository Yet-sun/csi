package com.csi.service.Impl;

import com.alibaba.fastjson.JSON;
import com.csi.dao.NoticeDao;
import com.csi.entity.Notice;
import com.csi.service.NoticeService;
import com.csi.util.ResponseResult;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * @Author: sunyue
 * @Description:
 * @Date: Create in 22:00 2019/9/16
 * @Version: 1.0
 */

@Service("NoticeService")
public class NoticeServiceImpl implements NoticeService {
    /**
     * @Author: sunyue
     * @Description:
     * @Version: 1.0
     */
    //自动注入NoticeDao
    @Autowired
    private NoticeDao noticeDao;


    @Override
    public List<Notice> findAllNotice() {
        /**
         * @Author: sunyue
         * @Description:
         * @param
         * @return: java.util.List<com.csi.entity.Notice>
         * @Version: 1.0
         */

        PageHelper.startPage(0, 10);
        List<Notice> notices = noticeDao.findAllNotice();
        return notices;
    }

    @Override
    public List<Notice> findNoticeFromInfo(String title, String content) {
        /**
         * @Author: sunyue
         * @Description:
         * @param title
         * @param content
         * @return: java.util.List<com.sy.entity.Notice>
         * @Version: 1.0
         */

        List<Notice> notices = noticeDao.findNoticeFromInfo(title, content);
        return notices;
    }

    @Override
    public List<Notice> findNoticeFromTitle(String title) {
        /**
         * @Author: sunyue
         * @Description:
         * @param title
         * @return: java.util.List<com.csi.entity.Notice>
         * @Version: 1.0
         */

        List<Notice> noticeList = noticeDao.findNoticeFromTitle(title);
        return noticeList;
    }

    @Override
    public List<Notice> findNoticeFromContent(String title) {
        /**
         * @Author: sunyue
         * @Description:
         * @param title
         * @return: java.util.List<com.csi.entity.Notice>
         * @Version: 1.0
         */

        List<Notice> noticeList = noticeDao.findNoticeFromContent(title);
        return noticeList;
    }

    @Override
    public Notice findNoticeFromId(Integer id) {
        /**
         * @Author: sunyue
         * @Description:
         * @param id
         * @return: com.sy.entity.Notice
         * @Version: 1.0
         */

        return noticeDao.findNoticeFromId(id);
    }

    @Override
    public void deleteNoticeFromId(Integer id) {
        /**
         * @Author: sunyue
         * @Description:
         * @param id
         * @return: java.lang.String
         * @Version: 1.0
         */


        noticeDao.deleteNoticeFromId(id);

    }

    @Override
    public void addNotice(String title, String content, Integer userId) {
        /**
         * @Author: sunyue
         * @Description:
         * @param title
         * @param content
         * @param createDate
         * @param userId
         * @return: java.lang.String
         * @Version: 1.0
         */

        Timestamp createDate = new Timestamp(new Date().getTime());
        noticeDao.addNotice(title, content, createDate, userId);

    }

    @Override
    public boolean updateNotice(String title, String userId, String content, String id) {
        /**
         * @Author: sunyue
         * @Description:
         * @param title
         * @param createDate
         * @param userId
         * @param remark
         * @param id
         * @return: java.lang.String
         * @Version: 1.0
         */

        Timestamp createDate = new Timestamp(new Date().getTime());
        try {
            noticeDao.updateNotice(title, createDate, userId, content, id);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
}
