package com.cloudsrcsoft.reportes.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import com.cloudsrcsoft.reportes.service.impl.ReportServiceImpl;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
@Service

public class FCMInitializer {
	private static final Logger log = LoggerFactory.getLogger(ReportServiceImpl.class);

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
