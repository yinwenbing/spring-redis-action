package cn.yinwenbing.mq.service;

import cn.yinwenbing.mq.model.AnnouncementMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * 消费者
 *
 * @author yinwenbing
 * @date 2023/2/3 10:15
 */
@Service
public class MessageConsumerService extends Thread {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private volatile boolean flag = true;

    private String queueKey = "queue";

    private Long popTime = 1000L;

    @Override
    public void run() {
        try {
            AnnouncementMessage message;
            // 为了能一直循环而不结束
            while (flag && !Thread.currentThread().isInterrupted()) {
                message = (AnnouncementMessage) redisTemplate.opsForList().rightPop(queueKey, popTime, TimeUnit.SECONDS);
                System.out.println("接收到了" + message);
            }
        } catch (Exception e) {
            System.err.println("消费者监听发生异常。异常信息：" + e.getMessage());
        }
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
