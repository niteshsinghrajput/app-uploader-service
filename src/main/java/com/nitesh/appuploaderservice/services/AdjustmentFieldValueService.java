package com.nitesh.appuploaderservice.services;

import com.nitesh.appuploaderservice.models.AdjustmentFieldValue;

import java.util.List;

public interface AdjustmentFieldValueService {
    AdjustmentFieldValue createFieldValue(AdjustmentFieldValue adjustmentFieldValue);
    List<AdjustmentFieldValue> getAdjustmentFieldValues();
}
