package com.cloudsrcsoft.reportes.repository.jpa;

import com.cloudsrcsoft.reportes.entity.BitacoraEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BitacoraRepository extends JpaRepository<BitacoraEntity, Long> {
}
