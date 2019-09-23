package com.csi.dao;

import com.csi.entity.Notice;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;

/**
 * @Author: sunyue
 * @Description:
 * @Date: Create in 21:39 2019/9/16
 * @Version: 1.0
 */
public interface NoticeDao {

    void deleteNoticeFromId(Integer id);

    List<Notice> selectByLimitAndOffset(@Param("limit") Integer limit, @Param("offset") Integer offset);

    void addNotice(@Param("content") String content, @Param("createDate") Timestamp createDate, @Param("userId") Integer userId);

    void updateNotice(@Param("title") String title, @Param("createDate") Timestamp createDate, @Param("userId") Integer userId, @Param("content") String content, @Param("id") Integer id);
}
