package com.chen.springbatch.common;

/**
 * @Author Chen
 * @Date 2020/6/18
 * @Time 02:49
 * @Description quartz定时任务相关常量
 **/

public interface QuartzConstants {
    // 阻塞
    Integer STATE_BLOCKED = 4;

    // 完成
    Integer STATE_COMPLETE = 2;

    // 错误
    Integer STATE_ERROR = 3;

    // 不存在
    Integer STATE_NONE =  -1;

    // 正常
    Integer STATE_NORMAL = 0;

    // 暂停
    Integer STATE_PAUSED = 1;
}
