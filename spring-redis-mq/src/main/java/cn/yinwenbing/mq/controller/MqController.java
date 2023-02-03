package cn.yinwenbing.mq.controller;

import cn.yinwenbing.mq.model.AnnouncementMessage;
import cn.yinwenbing.mq.service.MessageConsumerService;
import cn.yinwenbing.mq.service.MessageProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author yinwenbing
 * @date 2023/2/3 10:30
 */
@RestController
public class MqController {

    @Autowired
    private MessageProducerService producer;

    @Autowired
    private MessageConsumerService consumer;

    @PostMapping("/sendMessage")
    public void sendMessage(@RequestBody AnnouncementMessage message) {
        producer.sendMessage(message);
    }
}
