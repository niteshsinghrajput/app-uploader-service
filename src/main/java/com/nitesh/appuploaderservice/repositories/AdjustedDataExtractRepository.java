package com.nitesh.appuploaderservice.repositories;

import com.nitesh.appuploaderservice.models.AdjustedDataExtract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdjustedDataExtractRepository extends JpaRepository<AdjustedDataExtract, Integer> {

    String SQL = "SELECT * FROM {h-schema}adjusted_data_extract WHERE data_extract_id=:dataExtractId";
    @Query(value = SQL, nativeQuery = true)
    AdjustedDataExtract getDataExtractById(@Param("dataExtractId") Integer dataExtractId);
}
