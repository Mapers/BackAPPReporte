package com.cloudsrcsoft.reportes.repository.jpa;

import com.cloudsrcsoft.reportes.entity.UserNotificationConfigEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserNotificationConfigRepository extends JpaRepository<UserNotificationConfigEntity, Long> {

    @Modifying
    @Transactional
    @Query("delete from UserNotificationConfigEntity unc where unc.id = ?1")
    int deleteUserNotificationConfigById(Long id);
}
