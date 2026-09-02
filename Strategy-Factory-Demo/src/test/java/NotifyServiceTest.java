import com.example.dto.NotifyDTO;
import com.example.main.ApplicationContext;
import com.example.myEnum.NotifyChannelEnum;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.service.NotifyService;

import java.util.HashMap;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ApplicationContext.class})
public class NotifyServiceTest {

    @Autowired
    private NotifyService notifyService;

    /**
     * 业务调用示例
     */
    @org.junit.Test
    public void sendNotify() {
        // 短信
        NotifyDTO smsDto = new NotifyDTO();
        smsDto.setChannel(NotifyChannelEnum.SMS.getChannel());
        smsDto.setReceiver("13800138000");
        smsDto.setContent("您的订单已发货");
        smsDto.setExtendParam(new HashMap<String,Object>() {{
            put("templateCode", "SMS_123456");
        }});
        notifyService.sendNotify(smsDto);

        // 邮件
        NotifyDTO emailDto = new NotifyDTO();
        emailDto.setChannel(NotifyChannelEnum.EMAIL.getChannel());
        emailDto.setReceiver("test@xxx.com");
        emailDto.setTitle("订单通知");
        emailDto.setContent("您的订单已发货");
        notifyService.sendNotify(emailDto);

        //公众号
        NotifyDTO wechatDto = new NotifyDTO();
        wechatDto.setChannel(NotifyChannelEnum.WECHAT_OFFICIAL.getChannel());
        wechatDto.setReceiver("wx_openid_xxxx");
        wechatDto.setContent("您的订单已发货");
        wechatDto.setExtendParam(new HashMap<String,Object>(){{
            put("templateId","abc123");
        }});
        notifyService.sendNotify(wechatDto);
    }
}