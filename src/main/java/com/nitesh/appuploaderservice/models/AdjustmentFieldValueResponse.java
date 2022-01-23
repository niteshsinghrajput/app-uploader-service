package com.nitesh.appuploaderservice.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AdjustmentFieldValueResponse {

    @JsonProperty("record_id")
    private Integer recordId;

    @JsonProperty("field_value")
    private String fieldValue;

}
