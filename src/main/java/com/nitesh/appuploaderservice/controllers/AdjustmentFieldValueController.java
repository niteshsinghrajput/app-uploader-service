package com.nitesh.appuploaderservice.controllers;

import com.nitesh.appuploaderservice.models.AdjustmentFieldValue;
import com.nitesh.appuploaderservice.models.AdjustmentFieldValueResponse;
import com.nitesh.appuploaderservice.services.AdjustmentFieldValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("adjustment_field_values")
public class AdjustmentFieldValueController {

    @Autowired
    private AdjustmentFieldValueService service;

    @GetMapping
    public List<AdjustmentFieldValue> getAdjustmentFieldValues() {
        return service.getAdjustmentFieldValues();
    }

    @PostMapping
    public AdjustmentFieldValueResponse createAdjustedFieldValue(@RequestBody AdjustmentFieldValue adjustmentFieldValue) {
        return service.createFieldValue(adjustmentFieldValue);
    }
}

