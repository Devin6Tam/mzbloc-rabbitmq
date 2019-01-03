package com.mzbloc.rabbitmq.enums;

import org.springframework.util.StringUtils;

import java.io.Serializable;

/**
 * Created by tanxw on 2019/1/3.
 */
public enum TestQueueEnum implements Serializable {
    QUEUE_TEST_ONE("topic.exchange", "lzc.message", "测试1"),
    QUEUE_TEST_TWO("topic.exchange", "lzc.#", "测试2");


    private String topicCode;
    private String tagCode;
    private String desc;

    private TestQueueEnum(String topicCode, String tagCode, String desc) {
        this.topicCode = topicCode;
        this.tagCode = tagCode;
        this.desc = desc;
    }

    public String getTopicCode() {
        return this.topicCode;
    }

    public String getTagCode() {
        return this.tagCode;
    }

    public String getDesc() {
        return this.desc;
    }

    public static TestQueueEnum getMessageQueue(String topicCode, String tagCode) {
        if(StringUtils.isEmpty(topicCode)) {
            return null;
        } else if(StringUtils.isEmpty(tagCode)) {
            return null;
        } else {
            TestQueueEnum[] arr$ = values();
            int len$ = arr$.length;

            for(int i$ = 0; i$ < len$; ++i$) {
                TestQueueEnum temp = arr$[i$];
                if(temp.getTopicCode().equals(topicCode) && temp.getTagCode().equals(tagCode)) {
                    return temp;
                }
            }

            return null;
        }
    }
}
