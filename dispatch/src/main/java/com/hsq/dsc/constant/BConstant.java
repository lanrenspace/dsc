package com.hsq.dsc.constant;

/**
 * @Author lanrenspace@163.com
 * @Description:
 **/
public interface BConstant {

    /**
     * 备用池
     */
    Integer RESERVE_POOL = 0;

    /**
     * 工作池
     */
    Integer WORKING_POOL = 1;

    /**
     * 休息池
     */
    Integer HAVE_A_REST_POOL = 2;

    /**
     * 异常池
     */
    Integer UNUSUAL_POOL = 3;

    /**
     * 等待中
     */
    Integer T_WAIT = 0;

    /**
     * 关注目标检测中
     */
    Integer T_TARGET_CHECK = 1;

    /**
     * 执行队列中
     */
    Integer T_IN_QUEUE = 2;

    /**
     * 执行中
     */
    Integer T_EXEC_ING = 3;

    /**
     * 休息中
     */
    Integer T_HAVE_A_REST = 4;

    /**
     * 失败
     */
    Integer T_FAIL = 5;

    /**
     * 完成
     */
    Integer T_FINISH = 6;

    /**
     * 人工停止
     */
    Integer T_STOP = 7;
}
