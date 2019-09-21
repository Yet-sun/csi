package com.csi.controller;

import com.csi.entity.Notice;
import com.csi.service.NoticeService;
import com.csi.util.ResponseResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.alibaba.fastjson.JSON;


import java.util.List;

/**
 * @Author: sunyue
 * @Description:
 * @Date: Create in 22:00 2019/9/16
 * @Version: 1.0
 */
@Controller
@RequestMapping(value = "/api/bulletin/")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @ResponseBody
    @RequestMapping(value = "/SearchBulletinById/{id}", method = RequestMethod.GET)
    public Notice findNoticeFromId(@PathVariable Integer id) {
        Notice notices = noticeService.findNoticeFromId(id);
        System.out.println(notices);
        return notices;
    }

    @ResponseBody
    @RequestMapping(value = "/GetBulletin", method = RequestMethod.GET)
    public PageInfo<Notice> findAllNotice() {
        PageHelper.startPage(0, 10);
        List<Notice> notices = noticeService.findAllNotice();
        PageInfo<Notice> pageInfo = new PageInfo<>(notices);
        System.out.println(pageInfo);
        return pageInfo;
    }

    @ResponseBody
    @RequestMapping(value = "/GetBulletin/{title}", method = RequestMethod.GET)
    public PageInfo<Notice> findNoticeFromTitle(@PathVariable String title) {
        PageHelper.startPage(0, 10);
        List<Notice> noticeList = noticeService.findNoticeFromTitle(title);
        PageInfo<Notice> pageInfo = new PageInfo<>(noticeList);
        System.out.println(pageInfo);
        return pageInfo;
    }

    @ResponseBody
    @RequestMapping(value = "/GetBulletin/{content}", method = RequestMethod.GET)
    public PageInfo<Notice> findNoticeFromContent(@PathVariable String content) {
        PageHelper.startPage(0, 10);
        List<Notice> noticeList = noticeService.findNoticeFromContent(content);
        PageInfo<Notice> pageInfo = new PageInfo<>(noticeList);
        System.out.println(pageInfo);
        return pageInfo;
    }

    @ResponseBody
    @RequestMapping(value = "/GetBulletin/{title}/{content}", method = RequestMethod.GET)
    public PageInfo<Notice> findNoticeFromInfo(@PathVariable String title, @PathVariable String content) {
        PageHelper.startPage(0, 10);
        List<Notice> noticeList = noticeService.findNoticeFromInfo(title, content);
        PageInfo<Notice> pageInfo = new PageInfo<>(noticeList);
        System.out.println(pageInfo);
        return pageInfo;
    }

    @RequestMapping(value = "test", method = RequestMethod.POST, produces = "application/json")
    public String test(@RequestBody String jsonStr) {
        System.out.println(jsonStr);
        return jsonStr;
    }

    @ResponseBody
    @RequestMapping(value = "CreateBulletin", method = RequestMethod.POST, produces = "application/json")
    public String addNotice(@RequestBody String title, @RequestBody String content, @RequestBody Integer userId) throws Exception {
        System.out.println(title + content + userId);
        ResponseResult responseResult = new ResponseResult();
        try {
            noticeService.addNotice(title, content, userId);
            responseResult.setCode("200");
            responseResult.setMsg("添加成功");
            return JSON.toJSONString(responseResult);
        } catch (Exception e) {
            System.out.println(e);
            responseResult.setCode("400");
            responseResult.setMsg("添加失败");
            return JSON.toJSONString(responseResult);
        }
    }

    @ResponseBody
    @RequestMapping(value = "UpdateBulletin/", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
    public Boolean updateNotice(@PathVariable String title, @PathVariable String userId, @PathVariable String content, @PathVariable String id) throws Exception {
        Boolean status = noticeService.updateNotice(title, userId, content, id);
        System.out.println(status);
        return status;
    }

    @ResponseBody
    @RequestMapping(value = "DeleteBulletin/{id}", method = RequestMethod.DELETE, produces = "text/html;charset=UTF-8")
    public String deleteNoticeFromId(@PathVariable Integer id) {
        ResponseResult responseResult = new ResponseResult();
        try {
            noticeService.deleteNoticeFromId(id);
            responseResult.setCode("200");
            responseResult.setMsg("删除成功");
            return JSON.toJSONString(responseResult);
        } catch (Exception e) {
            System.out.println(e);
            responseResult.setCode("400");
            responseResult.setMsg("删除失败");
            return JSON.toJSONString(responseResult);
        }
    }

}
