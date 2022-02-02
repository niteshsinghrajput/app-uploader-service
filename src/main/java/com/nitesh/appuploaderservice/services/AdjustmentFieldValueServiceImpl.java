package com.nitesh.appuploaderservice.services;

import com.nitesh.appuploaderservice.models.Adjustment;
import com.nitesh.appuploaderservice.models.AdjustmentField;
import com.nitesh.appuploaderservice.models.AdjustmentFieldValue;
import com.nitesh.appuploaderservice.models.AdjustmentFieldValueResponse;
import com.nitesh.appuploaderservice.repositories.AdjustmentFieldRepository;
import com.nitesh.appuploaderservice.repositories.AdjustmentFieldValueRepository;
import com.nitesh.appuploaderservice.repositories.AdjustmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdjustmentFieldValueServiceImpl implements AdjustmentFieldValueService {

    @Autowired
    private AdjustmentFieldValueRepository repository;

    @Autowired
    private AdjustmentFieldRepository adjustmentFieldRepository;

    @Autowired
    private AdjustmentRepository adjustmentRepository;

    @Override
    public List<AdjustmentFieldValueResponse> createFieldValue(List<AdjustmentFieldValue> adjustmentFieldValues) {
        List<AdjustmentFieldValueResponse> responses = new ArrayList<>();
        if(adjustmentFieldValues != null && !adjustmentFieldValues.isEmpty()) {
            for(AdjustmentFieldValue value: adjustmentFieldValues) {
                AdjustmentField adjustmentField = adjustmentFieldRepository.getAdjustmentFieldByFieldId(value.getAdjustmentFieldData().getAdjustmentFieldId());
                Adjustment adjustment = adjustmentRepository.getAdjustmentByAdjustmentId(value.getAdjustment().getAdjustmentId());
                value.setAdjustmentFieldData(adjustmentField);
                value.setAdjustment(adjustment);
                AdjustmentFieldValueResponse fieldValue = new AdjustmentFieldValueResponse();
                AdjustmentFieldValue  createdAdjustmentFieldValue = repository.save(value);
                fieldValue.setFieldValue(createdAdjustmentFieldValue.getFieldValue());
                fieldValue.setRecordId(createdAdjustmentFieldValue.getRecordId());
                responses.add(fieldValue);
            }
        }
        return responses;
    }

    @Override
    public List<AdjustmentFieldValue> getAdjustmentFieldValues() {
        return repository.findAll();
    }

    @Override
    public void deleteAdjustmentValues(List<Integer> recordIds) {
        if(recordIds != null) {
            for(Integer recordId: recordIds) {
                repository.deleteById(recordId);
            }
        }
    }
}
