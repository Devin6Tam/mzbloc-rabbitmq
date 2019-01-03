package com.mzbloc.rabbitmq.sender;

import com.alibaba.fastjson.JSONObject;
import com.mzbloc.rabbitmq.constant.RabbitMQQueueConstant;
import com.mzbloc.rabbitmq.entity.UserEntity;
import com.mzbloc.rabbitmq.enums.TestQueueEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by tanxw on 2018/12/29.
 */
@Component
public class UserMQSender {

    private static Logger logger = LoggerFactory.getLogger(UserMQSender.class);

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sendDirectQueue(UserEntity user){
        System.out.print("sender:"+ JSONObject.toJSONString(user));
        amqpTemplate.convertAndSend(RabbitMQQueueConstant.QUEUE_TEST, user);
    }

    public void sendTopicQueue(List<UserEntity> userList) {
        logger.info("【sendTopic已发送消息】");
        // 第一个参数：TopicExchange名字
        // 第二个参数：Route-Key
        // 第三个参数：要发送的内容
        amqpTemplate.convertAndSend(TestQueueEnum.QUEUE_TEST_ONE.getTopicCode(),
                TestQueueEnum.QUEUE_TEST_ONE.getTagCode(), userList.get(0) );
        amqpTemplate.convertAndSend(TestQueueEnum.QUEUE_TEST_TWO.getTopicCode(),
                TestQueueEnum.QUEUE_TEST_TWO.getTagCode(), userList.get(1));
    }


    public void sendFanoutQueue(List<UserEntity> userList) {
        logger.info("【sendFanout已发送消息】");
        // 第一个参数：FanoutExchange名字
        // 第二个参数：fanout 交换器不处理路由键，这里简单的将队列绑定到交换器上
        // 每个发送到交换器的消息都会被转发到与该交换器绑定的所有队列上

        // 第三个参数：要发送的内容
        amqpTemplate.convertAndSend(RabbitMQQueueConstant.FANOUT_EXCHANGE_TEST, "", userList.get(0) );
        amqpTemplate.convertAndSend(RabbitMQQueueConstant.FANOUT_EXCHANGE_TEST, "", userList.get(1));
    }
}
