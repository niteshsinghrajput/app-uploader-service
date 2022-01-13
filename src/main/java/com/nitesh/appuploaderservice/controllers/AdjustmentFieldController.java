package com.nitesh.appuploaderservice.controllers;

import com.nitesh.appuploaderservice.models.AdjustmentField;
import com.nitesh.appuploaderservice.services.AdjustmentFieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("adjustment_fields")
public class AdjustmentFieldController {

    @Autowired
    private AdjustmentFieldService service;

    @GetMapping
    public List<AdjustmentField> getAdjustmentFields() {
        return service.getAdjustmentFields();
    }

    @PostMapping
    public AdjustmentField createAdjustmentField(@RequestBody AdjustmentField adjustmentField) {
        return service.createAdjustmentField(adjustmentField);
    }
}
