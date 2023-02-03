package cn.yinwenbing.mq.service;

import cn.yinwenbing.mq.model.AnnouncementMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * 生产者
 *
 * @author yinwenbing
 * @date 2023/2/3 10:17
 */
@Service
public class MessageProducerService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private String queueKey = "queue";

    public Long sendMessage(AnnouncementMessage message) {
        System.out.println("发送了" + message);
        return redisTemplate.opsForList().leftPush(queueKey, message);
    }
}
