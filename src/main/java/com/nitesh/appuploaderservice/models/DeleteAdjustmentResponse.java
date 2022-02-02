package com.nitesh.appuploaderservice.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DeleteAdjustmentResponse {

    @JsonProperty("adjustment_id")
    private Integer adjustmentId;

    @JsonProperty("message")
    private String message;
}
