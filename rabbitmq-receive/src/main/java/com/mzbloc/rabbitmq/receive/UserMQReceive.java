package com.mzbloc.rabbitmq.receive;

import com.alibaba.fastjson.JSONObject;
import com.mzbloc.rabbitmq.constant.RabbitMQQueueConstant;
import com.mzbloc.rabbitmq.entity.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by tanxw on 2019/1/3.
 */
@Component
public class UserMQReceive {

    private static Logger logger = LoggerFactory.getLogger(UserMQReceive.class);

    @RabbitListener(queues = {RabbitMQQueueConstant.QUEUE_TEST})
    public void receiverDirectQueue(UserEntity user) {
        logger.info("【receiverDirectQueue监听到消息】" + JSONObject.toJSONString(user));
    }


    @RabbitListener(queues = RabbitMQQueueConstant.QUEUE_TOPIC_TEST_ONE)
    public void receiveTopic1(UserEntity user) {
        logger.info("【receiveTopic1监听到消息】" + JSONObject.toJSONString(user));
    }
    @RabbitListener(queues = RabbitMQQueueConstant.QUEUE_TOPIC_TEST_TWO)
    public void receiveTopic2(UserEntity user) {
        logger.info("【receiveTopic2监听到消息】" + JSONObject.toJSONString(user));
    }

    @RabbitListener(queues = RabbitMQQueueConstant.QUEUE_FANOUT_TEST_THREE)
    public void receiveTopic3(UserEntity user) {
        logger.info("【receiveFanout1监听到消息】" + JSONObject.toJSONString(user));
    }
    @RabbitListener(queues = RabbitMQQueueConstant.QUEUE_FANOUT_TEST_FOUR)
    public void receiveTopic4(UserEntity user) {
        logger.info("【receiveFanout2监听到消息】" + JSONObject.toJSONString(user));
    }
}
