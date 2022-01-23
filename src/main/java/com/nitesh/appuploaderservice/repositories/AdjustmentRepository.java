package com.nitesh.appuploaderservice.repositories;

import com.nitesh.appuploaderservice.models.Adjustment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdjustmentRepository extends JpaRepository<Adjustment, Integer> {
    String SQL = "SELECT * FROM {h-schema}adjustment WHERE adjustment_id=:adjustmentId";
    @Query(value = SQL, nativeQuery = true)
    Adjustment getAdjustmentByAdjustmentId(@Param("adjustmentId") Integer adjustmentId);
}
