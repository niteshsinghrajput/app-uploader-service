package com.nitesh.appuploaderservice.services;

import com.nitesh.appuploaderservice.models.AdjustedDataExtract;
import com.nitesh.appuploaderservice.models.Adjustment;
import com.nitesh.appuploaderservice.models.AdjustmentFieldValue;
import com.nitesh.appuploaderservice.repositories.AdjustedDataExtractRepository;
import com.nitesh.appuploaderservice.repositories.AdjustmentFieldValueRepository;
import com.nitesh.appuploaderservice.repositories.AdjustmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdjustmentServiceImpl implements AdjustmentService {

    @Autowired
    private AdjustmentRepository repository;

    @Autowired
    private AdjustedDataExtractRepository adjustedDataExtractRepository;

    @Autowired
    private AdjustmentFieldValueRepository fieldValueRepository;

    @Override
    public List<Adjustment> saveAdjustments(List<Adjustment> adjustments) {
        List<Adjustment> payload = preparePayload(adjustments);
        if(payload != null && !payload.isEmpty())
            return repository.saveAll(payload);
        return null;
    }

    @Override
    public Adjustment saveAdjustment(Adjustment adjustment) {
        AdjustedDataExtract extract = adjustedDataExtractRepository.getDataExtractById(adjustment.getAdjustedDataExtract().getDataExtractId());
        adjustment.setAdjustedDataExtract(extract);
        return repository.save(adjustment);
    }

    @Override
    public Adjustment updateAdjustment(Integer adjustmentId, Adjustment adjustment) {
        Adjustment existingAdjustment = repository.getAdjustmentByAdjustmentId(adjustmentId);
        if(existingAdjustment != null) {
            existingAdjustment.setAdjustmentStatus(adjustment.getAdjustmentStatus());
            return repository.save(existingAdjustment);
        }
        return null;
    }

    @Override
    public List<Adjustment> getAdjustments() {
        return repository.findAll();
    }

    @Override
    public Boolean deleteAdjustment(Integer adjustmentId) {
        Adjustment adjustment = repository.getAdjustmentByAdjustmentId(adjustmentId);
        if (adjustment != null) {
            List<AdjustmentFieldValue> fieldValue = fieldValueRepository.getAdjustmentFieldValuesByAdjustmentId(adjustmentId);
            if(fieldValue != null) {
                fieldValueRepository.deleteAll(fieldValue);
            }
            repository.deleteById(adjustmentId);
            Boolean isDeleted = repository.existsById(adjustmentId);
            if (isDeleted)
                return false;
            else
                return true;
        }
        return false;
    }

    private List<Adjustment> preparePayload(List<Adjustment> adjustments) {
        List<Adjustment> payload = new ArrayList<>();
        if(adjustments != null && !adjustments.isEmpty()) {
            for(Adjustment adjustment: adjustments) {
                System.out.println("Data extract id : "+ adjustment);
                AdjustedDataExtract dataExtract = adjustedDataExtractRepository.getDataExtractById(adjustment.getAdjustedDataExtract().getDataExtractId());
                adjustment.setAdjustedDataExtract(dataExtract);
                payload.add(adjustment);
            }
            return payload;
        }
        return null;
    }

}