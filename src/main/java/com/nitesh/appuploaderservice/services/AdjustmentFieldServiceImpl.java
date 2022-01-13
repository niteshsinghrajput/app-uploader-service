package com.nitesh.appuploaderservice.services;

import com.nitesh.appuploaderservice.models.AdjustmentField;
import com.nitesh.appuploaderservice.repositories.AdjustmentFieldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdjustmentFieldServiceImpl implements AdjustmentFieldService {

    @Autowired
    private AdjustmentFieldRepository repository;

    @Override
    public List<AdjustmentField> getAdjustmentFields() {
        return repository.findAll();
    }

    @Override
    public AdjustmentField createAdjustmentField(AdjustmentField adjustmentField) {
        return repository.save(adjustmentField);
    }
}
