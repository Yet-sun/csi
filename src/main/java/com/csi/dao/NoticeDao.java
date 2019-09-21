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
    /**
     * @Author: sunyue
     * @Description: 查询所有通知
     * @Version: 1.0
     */
    List<Notice> findAllNotice();

    /**
     * @Author: sunyue
     * @Description: 通过输入的信息查询相应通知
     * @Version: 1.0
     */
    List<Notice> findNoticeFromInfo(@Param("title") String title, @Param("content") String content);

    /**
     * @Author: sunyue
     * @Description: 通过输入的title查询
     * @Version: 1.0
     */
    List<Notice> findNoticeFromTitle(String title);

    /**
     * @Author: sunyue
     * @Description: 通过输入的content查询
     * @Version: 1.0
     */
    List<Notice> findNoticeFromContent(String content);

    /**
     * @Author: sunyue
     * @Description: 通过id查询通知
     * @Version: 1.0
     */
    Notice findNoticeFromId(Integer id);

    /**
     * @Author: sunyue
     * @Description: 通过id删除通知
     * @Version: 1.0
     */
    void deleteNoticeFromId(Integer id);

    /**
     * @Author: sunyue
     * @Description: 添加通知
     * @Version: 1.0
     */
    void addNotice(@Param("title") String title, @Param("content") String content, @Param("createDate") Timestamp createDate, @Param("userId") Integer userId);

    /**
     * @Author: sunyue
     * @Description: 修改通知
     * @Version: 1.0
     */
    boolean updateNotice(@Param("title") String title, @Param("createDate") Timestamp createDate, @Param("userId") String userId, @Param("content") String content, @Param("id") String id);

}
