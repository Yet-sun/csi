package com.csi.service;

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
 * @Date: Create in 16:38 2019/9/17
 * @Version: 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class NoticeServiceTest {
    @Autowired
    private NoticeService noticeService;

    @Test
    public void findAllNotice() {
        List<Notice> notices = noticeService.findAllNotice();
        System.out.println(notices);
    }

    @Test
    public void findNoticeFromInfo() {
        String title = "test";
        String content = "test1";
        List<Notice> notices = noticeService.findNoticeFromInfo(title, content);
        System.out.println(notices);
    }

    @Test
    public void findNoticeFromId() {
//        int id = 2;
//        Notice notice = noticeService.findNoticeFromId(id);
//        System.out.println(notice);
    }

    @Test
    public void findUserNameFromId() {
    }

    @Test
    public void deleteNoticeFromId() {
        Integer id = 2;
        noticeService.deleteNoticeFromId(id);
        System.out.println("delete");
    }

    @Test
    public void addNotice() {
        noticeService.addNotice("notice", "noticeTest9", 4);
        System.out.println("add");
    }

    @Test
    public void updateNotice() {
        Boolean status = noticeService.updateNotice("noticeUpdate", "2", "noticeUpdate1","1");
        System.out.println(status);
    }

    @Test
    public void testFindNoticeFromInfo() {
    }

    @Test
    public void testFindUserNameFromId() {
    }

    @Test
    public void testDeleteNoticeFromId() {
    }

    @Test
    public void testAddNotice() {
    }

    @Test
    public void testUpdateNotice() {
    }
}