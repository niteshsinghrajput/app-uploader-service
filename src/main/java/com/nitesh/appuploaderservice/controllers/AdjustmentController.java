package com.nitesh.appuploaderservice.controllers;

import com.nitesh.appuploaderservice.models.Adjustment;
import com.nitesh.appuploaderservice.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdjustmentController {

    @Autowired
    private JsonUtil jsonUtil;

    @GetMapping("adjustments")
    public List<Adjustment> getAdjustments() {
        return jsonUtil.parseJson();
    }
}
