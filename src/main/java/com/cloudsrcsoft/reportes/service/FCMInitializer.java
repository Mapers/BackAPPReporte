package com.cloudsrcsoft.reportes.service;

import java.io.IOException;
import java.io.InputStream;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class FCMInitializer {
	private static final Logger log = LoggerFactory.getLogger(FCMInitializer.class);

	InputStream serviceAccount = this.getClass().getClassLoader().getResourceAsStream("./appreportehumanidadsur-firebase-adminsdk-ch7rp-ecce79413f.json");
    @PostConstruct
    public void initialize() {
        try {
        
        
        	FirebaseOptions options = new FirebaseOptions.Builder()
        			  .setCredentials(GoogleCredentials.fromStream(serviceAccount))
        			  //.setDatabaseUrl("https://turuta-757ba.firebaseio.com")
        			  .build();
            if (FirebaseApp.getApps().isEmpty()) {
                FirebaseApp.initializeApp(options);
                log.info("Firebase application has been initialized");
            }
        } catch (IOException e) {
        	log.error(e.getMessage());
        }
        
	
    }
}
