package com.nitesh.appuploaderservice.services;

import com.nitesh.appuploaderservice.models.Adjustment;

import java.util.List;

public interface AdjustmentService {

    List<Adjustment> saveAdjustments(List<Adjustment> adjustments);
    Adjustment saveAdjustment(Adjustment adjustment);
    Adjustment updateAdjustment(Integer adjustmentId, Adjustment adjustment);
    Boolean deleteAdjustment(Integer adjustmentId);
    List<Adjustment> getAdjustments();
}
