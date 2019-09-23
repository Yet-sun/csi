package com.csi.controller;

import com.csi.service.NoticeService;
import com.csi.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.alibaba.fastjson.JSON;


import javax.servlet.http.HttpSession;
import java.sql.Timestamp;

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
    @RequestMapping(method = RequestMethod.GET)
    public String selectByLimitAndOffset(Integer limit, Integer offset,@RequestParam(name = "searchText") String searchText) {
        ResponseResult responseResult = new ResponseResult();
        try {
            responseResult.setCode("200");
            responseResult.setMsg("查询成功");
            responseResult.setData(noticeService.selectByLimitAndOffset(limit, offset));
        } catch (Exception e) {
            responseResult.setCode("400");
            responseResult.setMsg("查询失败");
        }
        return JSON.toJSONString(responseResult);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public String addNotice(@RequestBody String content, Timestamp createDate, HttpSession httpSession) throws Exception {
        ResponseResult responseResult = new ResponseResult();
        try {
            noticeService.addNotice(content, createDate, (Integer) httpSession.getAttribute("userId"));
            System.out.println(content);
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
    @RequestMapping(method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
    public String updateNotice(@RequestBody String title, HttpSession httpSession, @RequestBody String content, @RequestBody Integer id) throws Exception {
        ResponseResult responseResult = new ResponseResult();
        try {
            noticeService.updateNotice(title, (Integer) httpSession.getAttribute("userId"), content, id);
            System.out.println(noticeService);
            responseResult.setCode("200");
            responseResult.setMsg("更新成功");
            return JSON.toJSONString(responseResult);
        } catch (Exception e) {
            System.out.println(e);
            responseResult.setCode("400");
            responseResult.setMsg("更新失败");
            return JSON.toJSONString(responseResult);
        }
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.DELETE, produces = "application/json;charset=UTF-8")
    public String deleteNoticeFromId(@PathVariable String ids) {
        ResponseResult responseResult = new ResponseResult();
        String[] id = ids.split(",");
        try {
            for (int i = 0; i < ids.length(); ++i) {
                noticeService.deleteNoticeFromId(Integer.valueOf(id[i]));
            }
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
