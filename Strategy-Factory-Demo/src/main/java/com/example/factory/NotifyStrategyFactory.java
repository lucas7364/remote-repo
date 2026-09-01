package com.example.factory;

import org.springframework.stereotype.Component;
import com.example.service.NotifyStrategy;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 通知工厂类
 */
@Component
public class NotifyStrategyFactory {

    @Resource
    private List<NotifyStrategy> notifyStrategyList;

    private final Map<String, NotifyStrategy> strategyMap = new HashMap<>();

    @PostConstruct
    public void init(){
        for (NotifyStrategy strategy : notifyStrategyList) {
            strategyMap.put(strategy.getChannel(), strategy);
        }
    }

    /**
     * 根据渠道获取对应的策略实现
     */
    public NotifyStrategy getStrategy(String channel){
        NotifyStrategy notifyStrategy = strategyMap.get(channel);
        if(notifyStrategy == null){
            throw new RuntimeException("不支持该通知渠道：" + channel);
        }
        return notifyStrategy;
    }
}
