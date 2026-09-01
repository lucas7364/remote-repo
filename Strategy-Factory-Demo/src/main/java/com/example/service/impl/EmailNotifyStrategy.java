package com.example.service.impl;


import com.example.dto.NotifyDTO;
import com.example.myEnum.NotifyChannelEnum;
import org.springframework.stereotype.Component;
import com.example.Strategy.NotifyStrategy;

@Component
public class EmailNotifyStrategy implements NotifyStrategy {

    @Override
    public boolean send(NotifyDTO notifyDTO) {
        String email = notifyDTO.getReceiver();
        String title = notifyDTO.getTitle();
        String content = notifyDTO.getContent();
        // spring mail发送邮件逻辑
        System.out.println("发送邮件>>邮箱:" + email + ",标题:"+title +",内容:"+content);
        return true;
    }

    @Override
    public String getChannel() {
        return NotifyChannelEnum.EMAIL.getChannel();
    }
}
