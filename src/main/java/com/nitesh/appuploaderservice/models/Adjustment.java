package com.nitesh.appuploaderservice.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "adjustment")
@Data
public class Adjustment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "adjustment_id")
    @JsonProperty("adjustment_id")
    private Long adjustmentId;

    @Column(name = "adjustment_start_date")
    @JsonProperty("adjustment_start_date")
    private String adjustmentStartDate;

    @Column(name = "adjustment_end_date")
    @JsonProperty("adjustment_end_date")
    private String adjustmentEndDate;

    @Column(name = "available_for_reviewer")
    @JsonProperty("available_for_reviewer")
    private String availableForReviewer;

    @Column(name = "adjustment_status")
    @JsonProperty("adjustment_status")
    private String adjustmentStatus;


}
