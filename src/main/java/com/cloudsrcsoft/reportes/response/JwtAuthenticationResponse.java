package com.cloudsrcsoft.reportes.response;

public class JwtAuthenticationResponse {
	private static final long serialVersionUID = 1250166508152483573L;

    private final String accessToken;
    private final long expiresAt;

    public JwtAuthenticationResponse(String token, long expiresAt) {
        this.accessToken = token;
        this.expiresAt = expiresAt;
    }

    public String getToken() {
        return this.accessToken;
    }

    public long getExpiresAt() {
        return expiresAt;
    }
}
