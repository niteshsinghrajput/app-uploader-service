package com.nitesh.appuploaderservice.controllers;

import com.nitesh.appuploaderservice.models.AdjustmentField;
import com.nitesh.appuploaderservice.models.AdjustmentFieldResponse;
import com.nitesh.appuploaderservice.services.AdjustmentFieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("adjustment_fields")
public class AdjustmentFieldController {

    @Autowired
    private AdjustmentFieldService service;

    @GetMapping
    public List<AdjustmentFieldResponse> getAdjustmentFields() {
        return service.getAdjustmentFields();
    }

    @PostMapping
    public AdjustmentFieldResponse createAdjustmentField(@RequestBody AdjustmentField adjustmentField) {
        return service.createAdjustmentField(adjustmentField);
    }
}
