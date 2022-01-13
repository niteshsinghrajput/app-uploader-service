package com.nitesh.appuploaderservice.repositories;

import com.nitesh.appuploaderservice.models.Adjustment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdjustmentRepository extends JpaRepository<Adjustment, Long> {
}
