package com.springboot.ref_code.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;

/**
 * 프로젝트 실행시 Firebase Admin sdk 초기화
 */
@Configuration
public class FcmInitialization {
    private Logger logger = LoggerFactory.getLogger(FcmInitialization.class);

    @PostConstruct
    public void main(){
        try {
            //Firebase Admin SDK파일 경로 지정
            InputStream serviceAccount = getClass().getClassLoader().getResourceAsStream("fcm.json");

            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();

            FirebaseApp.initializeApp(options);

            logger.info("FCM : " + options);

        } catch (IOException e) {
            logger.error("FCM Initialization failed",e);
        }
    }
}
