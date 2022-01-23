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
    public AdjustmentFieldValueResponse createFieldValue(AdjustmentFieldValue adjustmentFieldValue) {
        System.out.println(adjustmentFieldValue);

        AdjustmentField adjustmentField = adjustmentFieldRepository.getAdjustmentFieldByFieldId(adjustmentFieldValue.getAdjustmentFieldData().getAdjustmentFieldId());
        Adjustment adjustment = adjustmentRepository.getAdjustmentByAdjustmentId(adjustmentFieldValue.getAdjustment().getAdjustmentId());
        adjustmentFieldValue.setAdjustmentFieldData(adjustmentField);
        adjustmentFieldValue.setAdjustment(adjustment);
        AdjustmentFieldValueResponse fieldValue = new AdjustmentFieldValueResponse();
        AdjustmentFieldValue  createdAdjustmentFieldValue = repository.save(adjustmentFieldValue);
        fieldValue.setFieldValue(createdAdjustmentFieldValue.getFieldValue());
        fieldValue.setRecordId(createdAdjustmentFieldValue.getRecordId());
        return fieldValue;
    }

    @Override
    public List<AdjustmentFieldValue> getAdjustmentFieldValues() {
        return repository.findAll();
    }
}
