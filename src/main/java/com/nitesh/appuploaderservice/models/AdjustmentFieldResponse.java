package com.nitesh.appuploaderservice.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdjustmentFieldResponse {

    @JsonProperty("field_id")
    private Integer adjustmentFieldId;

    @JsonProperty("field_name")
    private String fieldName;

    @JsonProperty("adjustment_field_values")
    List<AdjustmentFieldValueResponse> adjustmentFieldValues;
}
