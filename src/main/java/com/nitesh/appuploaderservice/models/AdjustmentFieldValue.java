package com.nitesh.appuploaderservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "adjustment_field_values")
@Data
@JsonIgnoreProperties({"adjustment", "adjustment_field"})
public class AdjustmentFieldValue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "record_id")
    private Integer recordId;

    @Column(name = "field_value")
    @JsonProperty("field_value")
    private String fieldValue;


    @ManyToOne
    @JoinColumn(name = "adjustment_id")
    @JsonProperty("adjustment")
    Adjustment adjustment;

    @ManyToOne
    @JoinColumn(name = "field_id")
    @JsonProperty("adjustment_field")
    AdjustmentField adjustmentFieldData;
}
