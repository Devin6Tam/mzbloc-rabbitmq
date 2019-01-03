package com.mzbloc.rabbitmq.controller;

import com.mzbloc.rabbitmq.entity.UserEntity;
import com.mzbloc.rabbitmq.sender.UserMQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tanxw on 2019/1/3.
 */
@RestController
public class TestController {

    @Autowired
    private UserMQSender sender;

    @RequestMapping(value = "/sendDirectQueue",method = RequestMethod.POST)
    public Object sendDirectQueue() {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("devintam");
        userEntity.setPassword("123456");
        sender.sendDirectQueue(userEntity);
        return "ok";
    }

    @RequestMapping(value = "/sendTopicQueue",method = RequestMethod.POST)
    public Object sendTopicQueue() {
        List<UserEntity> userList = new ArrayList<>();
        UserEntity user1 = new UserEntity();
        user1.setUsername("jack lai");
        user1.setPassword("123456");
        userList.add(user1);

        UserEntity user2 = new UserEntity();
        user2.setUsername("jacky chen");
        user2.setPassword("123456");
        userList.add(user2);

        sender.sendTopicQueue(userList);
        return "ok";
    }

    @RequestMapping(value = "/sendFanoutQueue",method = RequestMethod.POST)
    public Object sendFanoutQueue() {
        List<UserEntity> userList = new ArrayList<>();
        UserEntity user1 = new UserEntity();
        user1.setUsername("jack lai");
        user1.setPassword("123456");
        userList.add(user1);

        UserEntity user2 = new UserEntity();
        user2.setUsername("jacky chen");
        user2.setPassword("123456");
        userList.add(user2);

        sender.sendFanoutQueue(userList);
        return "ok";
    }
}
