package com.csi.service;

import com.csi.entity.Notice;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;

/**
 * @Author: sunyue
 * @Description:
 * @Date: Create in 22:00 2019/9/16
 * @Version: 1.0
 */

public interface NoticeService {

    void deleteNoticeFromId(Integer id);

    void updateNotice(@Param("title") String title, @Param("userId") Integer userId, @Param("content") String content, @Param("id") Integer id);

    void addNotice(@Param("content") String content, @Param("createDate") Timestamp createDate, @Param("userId") Integer userId);

    List<Notice> selectByLimitAndOffset(@Param("limit") Integer limit, @Param("offset") Integer offset);
}
