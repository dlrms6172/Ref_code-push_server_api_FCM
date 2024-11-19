# Ref_code-push_server_api(FCM)

#### 1.project information
- build : maven(4.0.0)
- framework : springboot(2.0.2.RELEASE)

#### 2.project structure
- src
  - main
    - java
      - com
        - springboot
          - ref_code
            - config
              - [FcmInitialization.java](src%2Fmain%2Fjava%2Fcom%2Fspringboot%2Fref_code%2Fconfig%2FFcmInitialization.java) : resource 폴더 내의 fcm.json을 읽고 fcm admin sdk 초기화하는 클래스
            - controller
              - [NotificationController.java](src%2Fmain%2Fjava%2Fcom%2Fspringboot%2Fref_code%2Fcontroller%2FNotificationController.java) : 클라이언트에서 얻은 토큰과 제목,내용을 지정해서 알림을 보내는 클래스
            - service
              - [FcmService.java](src%2Fmain%2Fjava%2Fcom%2Fspringboot%2Fref_code%2Fservice%2FFcmService.java) : Firebase Cloud Messaging의 비즈니스 로직을 처리하는 서비스 클래스
    - resouces
      - static
        - [firebase-messaging-sw.js](src%2Fmain%2Fresources%2Fstatic%2Ffirebase-messaging-sw.js) : 푸시 알림을 받을 수 있게 설정하는 Service Worker 
      - templates
        - [index.html](src%2Fmain%2Fresources%2Ftemplates%2Findex.html) : 디바이스 토큰 출력,알림 수신하여 화면에 표시하는 페이지
      - [fcm.json](src%2Fmain%2Fresources%2Ffcm.json) : fcm admin sdk
#### 3.project description
해당 프로젝트는 FCM(Firebase Cloud Messaging)의 REST API를 학습하고, 이를 간단히 참고할 수 있도록 제작되었습니다.(화면은 단순히 확인용도로 제작, 서버쪽 코드 참고!)
