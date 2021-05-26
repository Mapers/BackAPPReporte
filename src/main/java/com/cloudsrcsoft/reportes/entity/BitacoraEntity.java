package com.cloudsrcsoft.reportes.entity;

import com.cloudsrcsoft.reportes.security.model.User;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "BITACORA")
public class BitacoraEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BitacoraSeq")
    @SequenceGenerator(name = "BitacoraSeq", sequenceName = "SEQ_BITACORA", allocationSize = 1)
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID", nullable = false)
    private User user;

    @Column(name = "IMEI")
    private String imei;

    @Column(name = "TYPE_PHONE")
    private String phoneType;

    @Column(name = "TYPE_MODEL")
    private String phoneModel;

    @Column(name = "DATE_INI")
    private LocalDateTime startDate = LocalDateTime.now();

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

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(String phoneType) {
        this.phoneType = phoneType;
    }

    public String getPhoneModel() {
        return phoneModel;
    }

    public void setPhoneModel(String phoneModel) {
        this.phoneModel = phoneModel;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return "BitacoraEntity{" +
                "id=" + id +
                ", user=" + user +
                ", imei='" + imei + '\'' +
                ", phoneType='" + phoneType + '\'' +
                ", phoneModel='" + phoneModel + '\'' +
                ", startDate=" + startDate +
                '}';
    }
}
