package com.nitesh.appuploaderservice.services;

import com.nitesh.appuploaderservice.models.AdjustmentFieldValue;
import com.nitesh.appuploaderservice.models.AdjustmentFieldValueResponse;

import java.util.List;

public interface AdjustmentFieldValueService {
    AdjustmentFieldValueResponse createFieldValue(AdjustmentFieldValue adjustmentFieldValue);
    List<AdjustmentFieldValue> getAdjustmentFieldValues();
}
