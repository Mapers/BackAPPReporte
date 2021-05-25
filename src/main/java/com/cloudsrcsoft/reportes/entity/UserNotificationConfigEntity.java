package com.cloudsrcsoft.reportes.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "USER_CONFIG_NOT")
public class UserNotificationConfigEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UserNotificationConfigSeq")
    @SequenceGenerator(name = "UserNotificationConfigSeq", sequenceName = "SEQ_USER_CONFIG_NOT", allocationSize = 1)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "ENABLED")
    private int enabled;

    @Column(name = "DATE_CONFIG")
    private LocalDate startDate;

    @Column(name = "DATE_CONFIG_END")
    private LocalDate endingDate;

    @Column(name = "TYPE_QUERY")
    private String typeQuery;

    @Column(name = "TYPE_QUERIES")
    private String typeQueries;

    @Column(name = "USER_ID")
    private Integer userId;

    @Column(name = "TYPE_SEND")
    private String sendingType;

    @Column(name = "SPECIALITIES")
    private String specialities;

    public UserNotificationConfigEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(LocalDate endingDate) {
        this.endingDate = endingDate;
    }

    public String getTypeQuery() {
        return typeQuery;
    }

    public void setTypeQuery(String typeQuery) {
        this.typeQuery = typeQuery;
    }

    public String getTypeQueries() {
        return typeQueries;
    }

    public void setTypeQueries(String typeQueries) {
        this.typeQueries = typeQueries;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getSendingType() {
        return sendingType;
    }

    public void setSendingType(String sendingType) {
        this.sendingType = sendingType;
    }

    public String getSpecialities() {
        return specialities;
    }

    public void setSpecialities(String specialities) {
        this.specialities = specialities;
    }

    @Override
    public String toString() {
        return "UserConfigNotificationEntity{" +
                "id=" + id +
                ", enabled=" + enabled +
                ", startDate=" + startDate +
                ", endingDate=" + endingDate +
                ", typeQuery='" + typeQuery + '\'' +
                ", typeQueries='" + typeQueries + '\'' +
                ", userId='" + userId + '\'' +
                ", sendingType='" + sendingType + '\'' +
                ", specialities='" + specialities + '\'' +
                '}';
    }

}
