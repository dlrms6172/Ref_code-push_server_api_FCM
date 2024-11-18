// firebase-messaging-sw.js
importScripts('https://www.gstatic.com/firebasejs/8.10.0/firebase-app.js');
importScripts('https://www.gstatic.com/firebasejs/8.10.0/firebase-messaging.js');

// Firebase 설정
const firebaseConfig = {
    apiKey: "AIzaSyDbzw5ORuEH_FJxzruVj3yvcVZ_-1KLf9U",
    authDomain: "test-99c0b.firebaseapp.com",
    projectId: "test-99c0b",
    storageBucket: "test-99c0b.firebasestorage.app",
    messagingSenderId: "452101951551",
    appId: "1:452101951551:web:25936ad6e8c9a53ec8e88a"
};

// Firebase 초기화
firebase.initializeApp(firebaseConfig);

// Firebase 메시징 초기화
const messaging = firebase.messaging();

// 백그라운드 메시지 처리
messaging.onBackgroundMessage((payload) => {
    console.log('Received background message ', payload);

    // 브라우저 알림 표시
    const notificationTitle = payload.notification.title;
    const notificationOptions = {
        body: payload.notification.body,
        icon: payload.notification.icon
    };

    self.registration.showNotification(notificationTitle, notificationOptions);
});