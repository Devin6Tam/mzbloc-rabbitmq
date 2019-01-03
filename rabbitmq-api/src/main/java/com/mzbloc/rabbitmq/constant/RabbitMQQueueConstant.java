package com.mzbloc.rabbitmq.constant;

/**
 * Created by tanxw on 2019/1/3.
 */
public class RabbitMQQueueConstant {
    /**
     * 消息队列测试【直连】
     */
    public static final String QUEUE_TEST = "mzbloc-user";

    /**
     * 消息队列测试【主题】
     */
    public static final String QUEUE_TOPIC_TEST_ONE = "topic.mzbloc-user1";

    public static final String QUEUE_TOPIC_TEST_TWO = "topic.mzbloc-user2";

    public static final String QUEUE_EXCHANGE_TEST = "topic.exchange";


    /**
     * 消息队列测试【广播】
     */
    public static final String QUEUE_FANOUT_TEST_THREE = "topic.mzbloc-user3";

    public static final String QUEUE_FANOUT_TEST_FOUR = "topic.mzbloc-user4";

    public static final String FANOUT_EXCHANGE_TEST = "fanout.exchange";
}
