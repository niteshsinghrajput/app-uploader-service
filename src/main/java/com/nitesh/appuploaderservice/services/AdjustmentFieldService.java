package com.nitesh.appuploaderservice.services;

import com.nitesh.appuploaderservice.models.AdjustmentField;
import com.nitesh.appuploaderservice.models.AdjustmentFieldResponse;

import java.util.List;

public interface AdjustmentFieldService {
    List<AdjustmentFieldResponse> getAdjustmentFields(Integer adjustmentId);
    AdjustmentFieldResponse createAdjustmentField(AdjustmentField adjustmentField);
}
