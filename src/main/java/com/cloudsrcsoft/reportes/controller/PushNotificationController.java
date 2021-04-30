package com.cloudsrcsoft.reportes.controller;

import com.cloudsrcsoft.reportes.request.PushNotificationRequest;

import com.cloudsrcsoft.reportes.response.PushNotificationResponse;
import com.cloudsrcsoft.reportes.service.PushNotificationService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping(value = "/noti")

public class PushNotificationController {
	private static final Logger log = LoggerFactory.getLogger(ReporteController.class);

	@Autowired
	  private PushNotificationService pushNotificationService;
	
	    @PostMapping("/notification/topic")
	    public ResponseEntity sendNotification(@RequestBody PushNotificationRequest request) {
	        pushNotificationService.sendPushNotificationWithoutData(request);
	        return new ResponseEntity<>(new PushNotificationResponse(HttpStatus.OK.value(), "Notification has been sent."), HttpStatus.OK);
	    }

	    @PostMapping("/notification/token")
	    public ResponseEntity sendTokenNotification(@RequestBody PushNotificationRequest request) {
	        pushNotificationService.sendPushNotificationToToken(request);
	        return new ResponseEntity<>(new PushNotificationResponse(HttpStatus.OK.value(), "Notification has been sent."), HttpStatus.OK);
	    }

	    @PostMapping("/notification/data")
	    public ResponseEntity sendDataNotification(@RequestBody PushNotificationRequest request) {
	        pushNotificationService.sendPushNotification(request);
	        return new ResponseEntity<>(new PushNotificationResponse(HttpStatus.OK.value(), "Notification has been sent."), HttpStatus.OK);
	    }

	    @PostMapping("/notification/data/customdatawithtopic")
	    public ResponseEntity sendDataNotificationCustom(@RequestBody PushNotificationRequest request) {
	        pushNotificationService.sendPushNotificationCustomDataWithTopic(request);
	        return new ResponseEntity<>(new PushNotificationResponse(HttpStatus.OK.value(), "Notification has been sent."), HttpStatus.OK);
	    }
	    @PostMapping("/notification/data/customdatawithtopicjson")
	    public ResponseEntity sendDataNotificationCustomWithSpecificJson(@RequestBody PushNotificationRequest request) {
	        pushNotificationService.sendPushNotificationCustomDataWithTopicWithSpecificJson(request);
	        return new ResponseEntity<>(new PushNotificationResponse(HttpStatus.OK.value(), "Notification has been sent."), HttpStatus.OK);
	    }

	    public void sendAutomaticNotification(){
	        PushNotificationRequest request = new PushNotificationRequest("","","","");
	        request.setTopic("global");
	        pushNotificationService.sendPushNotificationCustomDataWithTopicWithSpecificJson(request);
	    }
}
