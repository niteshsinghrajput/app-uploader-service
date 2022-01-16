package com.nitesh.appuploaderservice.services;

import com.nitesh.appuploaderservice.models.AdjustmentField;
import com.nitesh.appuploaderservice.models.AdjustmentFieldValue;
import com.nitesh.appuploaderservice.repositories.AdjustmentFieldRepository;
import com.nitesh.appuploaderservice.repositories.AdjustmentFieldValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdjustmentFieldServiceImpl implements AdjustmentFieldService {

    @Autowired
    private AdjustmentFieldRepository repository;

    @Autowired
    private AdjustmentFieldValueRepository fieldValueRepository;

    @Override
    public List<AdjustmentField> getAdjustmentFields() {
        List<AdjustmentField> adjustmentFieldList = new ArrayList<>();
        List<AdjustmentField> adjustmentFields = repository.findAll();
        for(AdjustmentField adjustmentField: adjustmentFields){
            List<AdjustmentFieldValue> fieldValues = fieldValueRepository.getFieldValuesByFieldId(adjustmentField.getAdjustmentFieldId());
            adjustmentField.setAdjustmentFieldValues(fieldValues);
            adjustmentFieldList.add(adjustmentField);
        }
        return adjustmentFieldList;
    }

    @Override
    public AdjustmentField createAdjustmentField(AdjustmentField adjustmentField) {
        return repository.save(adjustmentField);
    }
}
