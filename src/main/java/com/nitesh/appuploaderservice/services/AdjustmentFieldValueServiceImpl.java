package com.nitesh.appuploaderservice.services;

import com.nitesh.appuploaderservice.models.AdjustmentField;
import com.nitesh.appuploaderservice.models.AdjustmentFieldValue;
import com.nitesh.appuploaderservice.repositories.AdjustmentFieldRepository;
import com.nitesh.appuploaderservice.repositories.AdjustmentFieldValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdjustmentFieldValueServiceImpl implements AdjustmentFieldValueService {

    @Autowired
    private AdjustmentFieldValueRepository repository;

    @Autowired
    private AdjustmentFieldRepository adjustmentFieldRepository;

    @Override
    public AdjustmentFieldValue createFieldValue(AdjustmentFieldValue adjustmentFieldValue) {
        AdjustmentField adjustmentField = adjustmentFieldRepository.getAdjustmentFieldByFieldId(adjustmentFieldValue.getAdjustmentFieldData().getAdjustmentFieldId());
        adjustmentFieldValue.setAdjustmentFieldData(adjustmentField);
        return repository.save(adjustmentFieldValue);
    }

    @Override
    public List<AdjustmentFieldValue> getAdjustmentFieldValues() {
        return repository.findAll();
    }
}
