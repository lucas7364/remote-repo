package com.example.service;

import com.example.dto.NotifyDTO;
import com.example.factory.NotifyStrategyFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 通知业务服务层，对外提供调用
 */
@Service
public class NotifyService {

    @Resource
    private NotifyStrategyFactory notifyStrategyFactory;

    /**
     * 发送单渠道通知
     */
    public boolean sendNotify(NotifyDTO notifyDTO){
        NotifyStrategy strategy = notifyStrategyFactory.getStrategy(notifyDTO.getChannel());
        return strategy.send(notifyDTO);
    }

    /**
     * 支持一次给用户发送【多渠道同时通知】，比如同时短信+公众号
     */
    public void sendMultiChannelNotify(List<NotifyDTO> dtoList){
        for (NotifyDTO dto : dtoList) {
            sendNotify(dto);
        }
    }
}
