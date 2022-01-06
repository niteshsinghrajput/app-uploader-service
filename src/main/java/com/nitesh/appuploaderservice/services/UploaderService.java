package com.nitesh.appuploaderservice.services;

import com.nitesh.appuploaderservice.models.Adjustment;

import java.io.File;
import java.util.List;

public interface UploaderService {
    List<Adjustment> saveAdjustments(List<Adjustment> adjustments);
}
