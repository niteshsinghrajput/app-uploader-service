package com.nitesh.appuploaderservice.repositories;

import com.nitesh.appuploaderservice.models.AdjustedDataExtract;
import com.nitesh.appuploaderservice.models.AdjustmentField;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdjustmentFieldRepository extends JpaRepository<AdjustmentField, Integer> {

    String SQL = "SELECT * FROM {h-schema}adjustment_fields WHERE field_id=:fieldId";
    @Query(value = SQL, nativeQuery = true)
    AdjustmentField getAdjustmentFieldByFieldId(@Param("fieldId") Integer fieldId);
}
