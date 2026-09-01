package com.example.myEnum;

public enum NotifyChannelEnum {
    /** 短信 */
    SMS(1, "sms"),
    /** 邮件 */
    EMAIL(2, "email"),
    /** 微信公众号 */
    WECHAT_OFFICIAL(3, "wechat_official");

    private final Integer code;

    private final String channel;

    NotifyChannelEnum(Integer code, String channel) {
        this.code = code;
        this.channel = channel;
    }

    public String getChannel() {
        return channel;
    }
}
