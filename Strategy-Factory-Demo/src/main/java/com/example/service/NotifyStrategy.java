package com.example.service;

import com.example.dto.NotifyDTO;

/**
 * 通知抽象接口（策略接口）
 */
public interface NotifyStrategy {
    /**
     * 发送通知
     * @param notifyDTO 参数
     * @return true成功 false失败
     */
    boolean send(NotifyDTO notifyDTO);

    /**
     * 获取支持的渠道标识，用于工厂匹配
     */
    String getChannel();
}
