package com.hsq.dsc.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Author lanrenspace@163.com
 * @Description:
 **/
@Data
@TableName("dsc_follow_task_info")
public class FollowTaskInfo implements Serializable {

    /**
     * 主键ID
     */
    @TableId(type = IdType.INPUT)
    private Long id;

    /**
     * 任务名称
     */
    private String taskName;

    /**
     * 任务组
     */
    private Long taskGroupId;

    /**
     * 关注目标对象
     */
    private String followTargetAccount;

    /**
     * 关注目标UID
     */
    private String followTargetUid;

    /**
     * 关注目标SecUid
     */
    private String followTargetSecUid;

    /**
     * 目标关注量
     */
    private Long targetFollowNum;

    /**
     * 执行关注量
     */
    private Long executeFollowNum;

    /**
     * 完成关注量
     */
    private Long finishFollowNum;

    /**
     * 关注状态 class BConstant.T*
     */
    private Integer followStatus;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 开始时间
     */
    private LocalDateTime beginTime;

    /**
     * 开始执行时间
     */
    private LocalDateTime beginExecTime;

    /**
     * 完成时间
     */
    private LocalDateTime finishTime;

    /**
     * 备注
     */
    private String remark;
}
