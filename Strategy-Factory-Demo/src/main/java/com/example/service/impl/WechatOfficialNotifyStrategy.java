package com.example.service.impl;

import com.example.dto.NotifyDTO;
import com.example.myEnum.NotifyChannelEnum;
import org.springframework.stereotype.Component;
import com.example.service.NotifyStrategy;

/**
 * 微信公众号通知实现（模板消息）
 */
@Component
public class WechatOfficialNotifyStrategy implements NotifyStrategy {

    @Override
    public boolean send(NotifyDTO notifyDTO) {
        String openId = notifyDTO.getReceiver();
        String templateId = (String) notifyDTO.getExtendParam().get("templateId");
        // 调用微信公众号api发送模板消息
        System.out.println("公众号模板消息>>openId:"+openId+",模板id:"+templateId+",内容:"+notifyDTO.getContent());
        return true;
    }

    @Override
    public String getChannel() {
        return NotifyChannelEnum.WECHAT_OFFICIAL.getChannel();
    }
}
