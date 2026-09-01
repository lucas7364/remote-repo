package com.example.dto;

import lombok.Data;
import java.util.Map;

@Data
public class NotifyDTO {
    /** 用户标识：手机号/邮箱/微信openid */
    private String receiver;
    /** 通知标题（邮件用，短信可忽略） */
    private String title;
    /** 通知内容 */
    private String content;
    /** 渠道类型 com.exampl.myEnum.NotifyChannelEnum */
    private String channel;
    /** 渠道扩展参数
     * 短信：templateCode模板编号
     * 公众号：templateId模板id，miniProgram跳转参数等
     * 邮件：附件、抄送
     */
    private Map<String, Object> extendParam;
}
