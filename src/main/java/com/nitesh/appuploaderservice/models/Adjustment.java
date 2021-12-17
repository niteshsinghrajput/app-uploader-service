package com.nitesh.appuploaderservice.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Adjustment {

    @JsonProperty("adjustment_id")
    private Long adjustmentId;
    @JsonProperty("adjustment_start_date")
    private String adjustmentStartDate;
    @JsonProperty("adjustment_end_date")
    private String adjustmentEndDate;
    @JsonProperty("adjustment_for_reviewer")
    private Boolean availableForReviewer;
    @JsonProperty("adjustment_status")
    private String adjustmentStatus;

}
