package com.nitesh.appuploaderservice.services;

import com.nitesh.appuploaderservice.models.AdjustmentFieldValue;
import com.nitesh.appuploaderservice.models.AdjustmentFieldValueResponse;

import java.util.List;

public interface AdjustmentFieldValueService {
    List<AdjustmentFieldValueResponse> createFieldValue(List<AdjustmentFieldValue> adjustmentFieldValues);
    List<AdjustmentFieldValue> getAdjustmentFieldValues();
    void deleteAdjustmentValues(List<Integer> recordIds);
}
