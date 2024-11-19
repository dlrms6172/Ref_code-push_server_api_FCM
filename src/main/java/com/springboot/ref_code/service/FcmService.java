package com.springboot.ref_code.service;

import com.google.firebase.messaging.*;
import org.springframework.stereotype.Service;

@Service
public class FcmService {
    //웹 푸시 지정
    public void sendPushNotification(String token, String title, String body) {

        //Android 전용 설정
        AndroidConfig androidConfig = AndroidConfig.builder()
                .setPriority(AndroidConfig.Priority.HIGH) // 우선순위 설정 (HIGH 또는 NORMAL)
                .setNotification(AndroidNotification.builder()
                        .setSound("default") // 알림 사운드 지정
                        .setChannelId("important_channel") // Android 8.0 이상에서의 알림 채널 ID
                        .build())
                .build();

        //IOS 전용 설정(Apns:Apple Push Notification Service)
        ApnsConfig apnsConfig = ApnsConfig.builder()
                .setAps(Aps.builder()
                        .setAlert("example")
                        .setBadge(1)
                        .setSound("deault")
                        .build())
                .build();

        //Web 전용 설정
        WebpushConfig webpushConfig = WebpushConfig.builder()
                .setNotification(WebpushNotification.builder()
                        .setTitle(title)
                        .setBody(body)
                        .setIcon("https://example.com/icon.png") // 아이콘 이미지 URL
                        .build())
                .setFcmOptions(WebpushFcmOptions.builder()
                        .setLink("https://example.com/notification-click") // 클릭 시 이동할 URL
                        .build())
                .build();

        //추가적인 FCM 설정
        FcmOptions fcmOptions = FcmOptions.builder()
                .setAnalyticsLabel("campaign_label") // 캠페인 분석 레이블
                .build();


        //알림 설정
        Message message = Message.builder()
                .setNotification(Notification.builder()
                        .setTitle(title) //제목 지정
                        .setBody(body) //내용 지정
                        .setImage("http://test~")//이미지 주소 지정
                        .build())
                .setToken(token) //토큰 지정
                .setAndroidConfig(androidConfig)
                .setApnsConfig(apnsConfig)
                .setWebpushConfig(webpushConfig)
//                .setCondition("test in topics") //test라는 토픽을 구독한 사용자
//                .setFcmOptions(fcmOptions)
                .build();



        try {
            String response = FirebaseMessaging.getInstance().send(message);
            System.out.println("Successfully sent message: " + response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
