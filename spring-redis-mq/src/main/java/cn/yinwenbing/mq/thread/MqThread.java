package cn.yinwenbing.mq.thread;

import cn.yinwenbing.mq.service.MessageConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author yinwenbing
 * @date 2023/2/3 10:14
 */
@Component
public class MqThread implements ApplicationRunner {

    @Autowired
    MessageConsumerService messageConsumerService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("启动消费者监听程序");
        messageConsumerService.start();
    }
}
