package com.hsq.dsc.utils;


//import lombok.extern.slf4j.Slf4j;

/**
 * @Author lanrenspace@163.com
 * @Description:
 **/
//@Slf4j
public class ID {



    private final long workerId;

    private final long epoch = 1577808000000L;

    private final long workerIdBits = 10L;      // 机器标识位数

    private final long maxWorkerId = ~(-1L << this.workerIdBits);// 机器ID最大值: 1023

    private long sequence = 0L;                   // 0，并发控制

    private final long sequenceBits = 12L;      //毫秒内自增位

    private final long workerIdShift = this.sequenceBits;

    private final long timestampLeftShift = this.sequenceBits + this.workerIdBits;// 22

    private final long sequenceMask = ~(-1L << this.sequenceBits);

    private long lastTimestamp = -1L;

    private static final ID ID = new ID(1);

    private ID(long workerId) {

        if (workerId > this.maxWorkerId || workerId < 0) {

            throw new IllegalArgumentException(String.format("worker Id can't be greater than %d or less than 0", this.maxWorkerId));
        }
        this.workerId = workerId;
    }

    public static ID getInstance() {

        return ID;

    }

    /**
     * 生成序列ID
     *
     * @return
     * @throws Exception
     */

    public synchronized long nextId() throws Exception {

        long timestamp = timeGen();

        if (this.lastTimestamp == timestamp) {

            // 如果上一个timestamp与新产生的相等，则sequence加一(0-4095循环); 对新的timestamp，sequence从0开始

            this.sequence = this.sequence + 1 & this.sequenceMask;

            if (this.sequence == 0) {

                timestamp = this.tilNextMillis(this.lastTimestamp);// 重新生成timestamp

            }

        } else {

            this.sequence = 0;

        }

        if (timestamp < this.lastTimestamp) {

//            log.error(String.format("clock moved backwards.Refusing to generate id for %d milliseconds", (this.lastTimestamp - timestamp)));

            throw new Exception(String.format("clock moved backwards.Refusing to generate id for %d milliseconds", (this.lastTimestamp - timestamp)));

        }

        this.lastTimestamp = timestamp;

        return timestamp - this.epoch << this.timestampLeftShift | this.workerId << this.workerIdShift | this.sequence;
    }

    /**
     * 等待下一个毫秒的到来, 保证返回的毫秒数在参数lastTimestamp之后
     */

    private long tilNextMillis(long lastTimestamp) {

        long timestamp = timeGen();

        while (timestamp <= lastTimestamp) {

            timestamp = timeGen();

        }

        return timestamp;

    }

    /**
     * 获得系统当前毫秒数
     */

    private static long timeGen() {

        return System.currentTimeMillis();

    }
}
