package com.nitesh.appuploaderservice.models;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "adjusted_data_extract")
@Data
public class AdjustedDataExtract implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "data_extract_id")
    @JsonProperty("data_extract_id")
    private Integer dataExtractId;

    @Column(name = "created_time")
    private Timestamp createdTime;

    @Column(name = "file_location")
    private String fileLocation;

    @Column(name = "upload_time")
    private Timestamp uploadTime;

    @JsonIgnore
    @OneToMany(mappedBy = "adjustedDataExtract", fetch = FetchType.LAZY)
    private List<Adjustment> adjustments;
}
