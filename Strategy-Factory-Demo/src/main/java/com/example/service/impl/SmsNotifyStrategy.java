package com.example.service.impl;

import com.example.dto.NotifyDTO;
import com.example.myEnum.NotifyChannelEnum;
import org.springframework.stereotype.Component;
import com.example.service.NotifyStrategy;

/**
 * 短信通知实现
 */
@Component
public class SmsNotifyStrategy implements NotifyStrategy {

    @Override
    public boolean send(NotifyDTO notifyDTO) {
        String phone = notifyDTO.getReceiver();
        String templateCode = (String) notifyDTO.getExtendParam().get("templateCode");
        String content = notifyDTO.getContent();
        // 调用第三方短信SDK/阿里云、腾讯云短信接口
        System.out.println("发送短信>>手机号:" + phone + ",模板:"+templateCode +",内容:"+content);
        return true;
    }

    @Override
    public String getChannel() {
        return NotifyChannelEnum.SMS.getChannel();
    }
}
