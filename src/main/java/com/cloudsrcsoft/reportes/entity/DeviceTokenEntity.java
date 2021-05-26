package com.cloudsrcsoft.reportes.entity;

import com.cloudsrcsoft.reportes.security.model.User;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TOKEN_DISPOSITIVO")
public class DeviceTokenEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DeviceTokenSeq")
    @SequenceGenerator(name = "DeviceTokenSeq", sequenceName = "SEQ_TOKEN_DISPOSITIVO", allocationSize = 1)
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID", nullable = false)
    private User user;

    @Column(name = "TOKEN_ID")
    private String token;

    @Column(name = "DEVICE")
    private String device;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    @Override
    public String toString() {
        return "DeviceTokenEntity{" +
                "id=" + id +
                ", user=" + user +
                ", token='" + token + '\'' +
                ", device='" + device + '\'' +
                '}';
    }
}
