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
@TableName("dsc_account_pool")
public class AccountPool implements Serializable {

    /**
     * 主键ID
     */
    @TableId(type = IdType.INPUT)
    private Long id;

    /**
     * 账号UID
     */
    private String uid;

    /**
     * 当前所在池类型 class BConstant
     */
    private Integer poolType;

    /**
     * 账号loginData
     */
    private String loginData;

    /**
     * 缓存同步 true or false
     */
    private Boolean cacheSyncFlag;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 上次工作时间
     */
    private LocalDateTime lastWorkingTime;
}
