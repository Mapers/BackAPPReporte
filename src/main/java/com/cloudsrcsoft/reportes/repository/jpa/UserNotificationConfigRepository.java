package com.cloudsrcsoft.reportes.repository.jpa;

import com.cloudsrcsoft.reportes.entity.UserNotificationConfigEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserNotificationConfigRepository extends JpaRepository<UserNotificationConfigEntity, Long> {
}
