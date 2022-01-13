package com.nitesh.appuploaderservice.services;

import com.nitesh.appuploaderservice.models.AdjustmentField;

import java.util.List;

public interface AdjustmentFieldService {
    List<AdjustmentField> getAdjustmentFields();

    AdjustmentField createAdjustmentField(AdjustmentField adjustmentField);
}
