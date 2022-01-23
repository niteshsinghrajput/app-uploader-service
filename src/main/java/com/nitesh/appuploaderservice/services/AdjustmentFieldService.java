package com.nitesh.appuploaderservice.services;

import com.nitesh.appuploaderservice.models.AdjustmentField;
import com.nitesh.appuploaderservice.models.AdjustmentFieldResponse;

import java.util.List;

public interface AdjustmentFieldService {
    List<AdjustmentFieldResponse> getAdjustmentFields();
    AdjustmentFieldResponse createAdjustmentField(AdjustmentField adjustmentField);
}
