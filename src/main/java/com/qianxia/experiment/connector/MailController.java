package com.qianxia.experiment.connector;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author qianxia
 * @date 2021/11/16  14:05
 */
public class MailController {

    @Resource
    private JavaMailSender javaMailSender;

    @GetMapping("/test")
    public void demo() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("Maleon@startdt.com");
        message.setTo("867724561@qq.com");
        message.setSubject("邮件发送测试");
        message.setText("你好，世界");
        javaMailSender.send(message);
    }

    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime tomorrow = now.plusDays(1L);
        System.out.println(Duration.between(tomorrow, now).toDays());

        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);


        Map<Integer, List<Integer>> newGroupIdAndOldComponentIdListMap = new HashMap<>(8);
        newGroupIdAndOldComponentIdListMap.put(1, list1);
        newGroupIdAndOldComponentIdListMap.put(2, list2);

        Map<Integer, Integer> oldComponentIdAndNewComponentIdMap = new HashMap<>(8);
        oldComponentIdAndNewComponentIdMap.put(1, 11);
        oldComponentIdAndNewComponentIdMap.put(2, 22);
        oldComponentIdAndNewComponentIdMap.put(3, 33);
        oldComponentIdAndNewComponentIdMap.put(4, 44);

        newGroupIdAndOldComponentIdListMap.forEach((newGroupId, oldComponentIdList) -> {
            List<Integer> newComponentIdList = oldComponentIdList.parallelStream()
                    .map(oldComponentIdAndNewComponentIdMap::get)
                    .collect(Collectors.toList());
            System.out.println("groupId:" + newGroupId + "idList:" + newComponentIdList);
        });


    }
}
