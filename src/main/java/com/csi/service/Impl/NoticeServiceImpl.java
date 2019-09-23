package com.csi.service.Impl;

import com.csi.dao.NoticeDao;
import com.csi.entity.Notice;
import com.csi.service.NoticeService;
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

    @Autowired
    private NoticeDao noticeDao;

    @Override
    public void deleteNoticeFromId(Integer id) {
        noticeDao.deleteNoticeFromId(id);
    }

    @Override
    public void addNotice(String content, Timestamp createDate, Integer userId) {
        createDate = new Timestamp(new Date().getTime());
        noticeDao.addNotice(content, createDate, userId);
    }

    @Override
    public void updateNotice(String title, Integer userId, String content, Integer id) {
        Timestamp createDate = new Timestamp(new Date().getTime());
        noticeDao.updateNotice(title, createDate, userId, content, id);
    }

    @Override
    public List<Notice> selectByLimitAndOffset(Integer limit, Integer offset) {
        List<Notice> noticeList = noticeDao.selectByLimitAndOffset(limit, offset);
        return noticeList;
    }
}
