package com.mzbloc.rabbitmq.receive;

import com.mzbloc.rabbitmq.constant.RabbitMQQueueConstant;
import com.mzbloc.rabbitmq.enums.TestQueueEnum;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by tanxw on 2018/12/29.
 */
@Configuration
public class RabbitmqReceiveConfiguration {

    @Bean
    public Queue directQueue() {
        // 第一个参数是队列名字， 第二个参数是指是否持久化
        return new Queue(RabbitMQQueueConstant.QUEUE_TEST, true);
    }

    /**
     * Topic模式
     * @return
     */
    @Bean
    public Queue topicQueue1() {
        return new Queue(RabbitMQQueueConstant.QUEUE_TOPIC_TEST_ONE);
    }
    @Bean
    public Queue topicQueue2() {
        return new Queue(RabbitMQQueueConstant.QUEUE_TOPIC_TEST_TWO);
    }
    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(RabbitMQQueueConstant.QUEUE_EXCHANGE_TEST);
    }
    @Bean
    public Binding topicBinding1() {
        return BindingBuilder.bind(topicQueue1()).to(topicExchange()).with(TestQueueEnum.QUEUE_TEST_ONE.getTagCode());
    }
    @Bean
    public Binding topicBinding2() {
        return BindingBuilder.bind(topicQueue2()).to(topicExchange()).with(TestQueueEnum.QUEUE_TEST_TWO.getTagCode());
    }


    /**
     * Fanout模式
     * @return
     */
    @Bean
    public Queue topicQueue3() {
        return new Queue(RabbitMQQueueConstant.QUEUE_FANOUT_TEST_THREE);
    }
    @Bean
    public Queue topicQueue4() {
        return new Queue(RabbitMQQueueConstant.QUEUE_FANOUT_TEST_FOUR);
    }
    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(RabbitMQQueueConstant.FANOUT_EXCHANGE_TEST);
    }
    @Bean
    public Binding topicBinding3() {
        return BindingBuilder.bind(topicQueue3()).to(fanoutExchange());
    }
    @Bean
    public Binding topicBinding4() {
        return BindingBuilder.bind(topicQueue4()).to(fanoutExchange());
    }

}