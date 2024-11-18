package com.springboot.ref_code.controller;

import com.springboot.ref_code.service.FcmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {

    @Autowired
    FcmService fcmService;

    @PostMapping("/sendNotification")
    public void sendNotification(@RequestParam String token, @RequestParam String title, @RequestParam String body) {
        fcmService.sendPushNotification(token, title, body);
    }
}
