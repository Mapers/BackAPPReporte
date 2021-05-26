package com.cloudsrcsoft.reportes.request;

public class PushNotificationRequest {


	public PushNotificationRequest(String title, String message, String topic, String token) {
		super();
		this.title = title;
		this.message = message;
		this.topic = topic;
		this.token = token;
	}

	private String title;
    private String message;

    public void setTopic(String topic) {
        this.topic = topic;
    }

    private String topic;
    private String token;

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public String getTopic() {
        return topic;
    }

    public String getToken() {
        return token;
    }

    @Override
    public String toString() {
        return "PushNotificationRequest{" +
                "title='" + title + '\'' +
                ", message='" + message + '\'' +
                ", topic='" + topic + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}