package com.example.Notification.Service._7.service;

import com.google.firebase.messaging.FirebaseMessaging;
import org.springframework.beans.factory.annotation.Value;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Service
// read path app.firebase-configuration-file and use @Value insert firebaseConfigPath
public class FCMInitializer {
    @Value("${app.firebase-configuration-file}")
    private String firebaseConfigPath;
    Logger logger = LoggerFactory.getLogger(FCMInitializer.class);
    // allows the initialize() method to be called on application start-up
    @PostConstruct
    public void initialize() {
        try {
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(new ClassPathResource(firebaseConfigPath).getInputStream())).build();
                    if(FirebaseApp.getApps().isEmpty()) {
                        FirebaseApp.initializeApp(options);
                        logger.info("___________Firebase application initialized__________");
                    }
        } catch (IOException e){
            logger.info("________Connect to Firebase fall________");
            logger.error(e.getMessage());
        }
    }
    @Bean
    public FirebaseMessaging firebaseMessaging() {
        return FirebaseMessaging.getInstance();
    }
}
