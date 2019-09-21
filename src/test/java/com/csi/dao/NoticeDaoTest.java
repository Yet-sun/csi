package com.csi.dao;

import com.csi.entity.Notice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @Author: sunyue
 * @Description:
 * @Date: Create in 21:43 2019/9/16
 * @Version: 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class NoticeDaoTest {
    @Autowired
    private NoticeDao noticeDao;

    @Test
    public void findAllNotice() {
        List<Notice> notices = noticeDao.findAllNotice();
        System.out.println(notices);
    }

    @Test
    public void findNoticeFromInfo() {

    }

    @Test
    public void findNoticeFromId() {
        int id = 2;
        Notice notice = noticeDao.findNoticeFromId(id);
        System.out.println(notice);
    }

    @Test
    public void findUserNameFromId() {
    }

    @Test
    public void deleteNoticeFromId() {
    }

    @Test
    public void addNotice() {
    }

    @Test
    public void updateNotice() {
    }
}