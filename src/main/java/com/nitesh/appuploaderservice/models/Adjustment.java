package com.nitesh.appuploaderservice.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "adjustment")
@Getter
@Setter
public class Adjustment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "adjustment_id")
    @JsonProperty("adjustment_id")
    private Integer adjustmentId;

    @Column(name = "adjustment_start_date")
    @JsonProperty("adjustment_start_date")
    @Temporal(TemporalType.DATE)
    private Date adjustmentStartDate;

    @Column(name = "adjustment_end_date")
    @JsonProperty("adjustment_end_date")
    @Temporal(TemporalType.DATE)
    private Date adjustmentEndDate;

    @Column(name = "available_for_reviewer")
    @JsonProperty("available_for_reviewer")
    private String availableForReviewer;

    @Column(name = "adjustment_status")
    @JsonProperty("adjustment_status")
    private String adjustmentStatus;

    @JsonIgnore
    @OneToMany(mappedBy = "adjustment", fetch = FetchType.LAZY)
    private List<AdjustmentFieldValue> adjustmentFieldValues;

    @ManyToOne
    @JoinColumn(name = "data_extract_id")
    @JsonProperty("adjusted_data_extract")
    AdjustedDataExtract adjustedDataExtract;

}
