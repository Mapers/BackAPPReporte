package com.cloudsrcsoft.reportes.repository.jpa;

import com.cloudsrcsoft.reportes.entity.DeviceTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface DeviceTokenRepository extends JpaRepository<DeviceTokenEntity, Long> {
    List<DeviceTokenEntity> findAllByToken(String token);

    @Modifying
    @Transactional
    @Query(value = "delete from DeviceTokenEntity dte where dte.token = ?1")
    int deleteDeviceTokenByToken(String token);
}
