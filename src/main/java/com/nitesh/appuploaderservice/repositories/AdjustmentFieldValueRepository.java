package com.nitesh.appuploaderservice.repositories;

import com.nitesh.appuploaderservice.models.AdjustmentField;
import com.nitesh.appuploaderservice.models.AdjustmentFieldValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdjustmentFieldValueRepository extends JpaRepository<AdjustmentFieldValue, Integer> {
    String SQL = "SELECT * FROM {h-schema}adjustment_field_values WHERE field_id=:fieldId";
    @Query(value = SQL, nativeQuery = true)
    List<AdjustmentFieldValue> getFieldValuesByFieldId(@Param("fieldId") Integer fieldId);
}
