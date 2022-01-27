package com.nitesh.appuploaderservice.services;

import com.nitesh.appuploaderservice.models.AdjustmentField;
import com.nitesh.appuploaderservice.models.AdjustmentFieldResponse;
import com.nitesh.appuploaderservice.models.AdjustmentFieldValue;
import com.nitesh.appuploaderservice.models.AdjustmentFieldValueResponse;
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
    public List<AdjustmentFieldResponse> getAdjustmentFields(Integer adjustmentId) {
        List<AdjustmentFieldResponse> responses = new ArrayList<>();
        List<AdjustmentField> adjustmentFields = repository.findAll();
        for (AdjustmentField adjustmentField : adjustmentFields) {
            AdjustmentFieldResponse response = new AdjustmentFieldResponse();
            response.setFieldName(adjustmentField.getFieldName());
            response.setAdjustmentFieldId(adjustmentField.getAdjustmentFieldId());
            List<AdjustmentFieldValue> values = fieldValueRepository.getFieldValuesByFieldIdAndAdjustmentId(adjustmentField.getAdjustmentFieldId(), adjustmentId);
            List<AdjustmentFieldValueResponse> fieldValueResponses = new ArrayList<>();
            if (values != null && !values.isEmpty()) {
                for (AdjustmentFieldValue value : values) {
                    AdjustmentFieldValueResponse valueResponse = new AdjustmentFieldValueResponse();
                    valueResponse.setFieldValue(value.getFieldValue());
                    valueResponse.setRecordId(value.getRecordId());
                    fieldValueResponses.add(valueResponse);
                }

            }
            response.setAdjustmentFieldValues(fieldValueResponses);
            responses.add(response);
        }
        return responses;
    }

    @Override
    public List<AdjustmentFieldResponse> createAdjustmentField(List<AdjustmentField> adjustmentFields) {

        List<AdjustmentField> createdField = repository.saveAll(adjustmentFields);
        List<AdjustmentFieldResponse> responses = new ArrayList<>();
        if (createdField != null && !createdField.isEmpty()) {
            for (AdjustmentField field : createdField) {
                AdjustmentFieldResponse response = new AdjustmentFieldResponse();
                response.setFieldName(field.getFieldName());
                response.setAdjustmentFieldId(field.getAdjustmentFieldId());
                List<AdjustmentFieldValue> values = fieldValueRepository.getFieldValuesByFieldId(field.getAdjustmentFieldId());
                List<AdjustmentFieldValueResponse> fieldValueResponses = new ArrayList<>();
                if (values != null && !values.isEmpty()) {
                    for (AdjustmentFieldValue value : values) {
                        AdjustmentFieldValueResponse valueResponse = new AdjustmentFieldValueResponse();
                        valueResponse.setFieldValue(value.getFieldValue());
                        valueResponse.setRecordId(value.getRecordId());
                        fieldValueResponses.add(valueResponse);
                    }
                }
                response.setAdjustmentFieldValues(fieldValueResponses);
                responses.add(response);
            }
        }
        return responses;
    }
}
