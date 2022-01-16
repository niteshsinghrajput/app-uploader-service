package com.nitesh.appuploaderservice.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "adjustment_fields")
@Data
public class AdjustmentField {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "field_id")
    @JsonProperty("field_id")
    private Integer adjustmentFieldId;

    @Column(name = "field_name")
    @JsonProperty("field_name")
    private String fieldName;

    @OneToMany(mappedBy = "adjustmentFieldData")
    @JsonProperty("adjustment_field_values")
    List<AdjustmentFieldValue> adjustmentFieldValues;


}
