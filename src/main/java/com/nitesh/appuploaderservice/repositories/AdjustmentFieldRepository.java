package com.nitesh.appuploaderservice.repositories;

import com.nitesh.appuploaderservice.models.AdjustmentField;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdjustmentFieldRepository extends JpaRepository<AdjustmentField, Long> {
}
