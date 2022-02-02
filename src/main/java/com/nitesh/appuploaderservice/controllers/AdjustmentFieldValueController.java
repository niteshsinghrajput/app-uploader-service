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
    public List<AdjustmentFieldValueResponse> createAdjustedFieldValue(@RequestBody List<AdjustmentFieldValue> adjustmentFieldValue) {
        return service.createFieldValue(adjustmentFieldValue);
    }

    @DeleteMapping
    public String deleteFieldValues(@RequestParam("record_id")List<Integer> recordIds) {
        service.deleteAdjustmentValues(recordIds);
        return "field values for record ids "+recordIds+" have been deleted successfully";
    }

}

