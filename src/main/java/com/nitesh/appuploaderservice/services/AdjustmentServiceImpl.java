package com.nitesh.appuploaderservice.services;

import com.nitesh.appuploaderservice.models.AdjustedDataExtract;
import com.nitesh.appuploaderservice.models.Adjustment;
import com.nitesh.appuploaderservice.repositories.AdjustedDataExtractRepository;
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
    public List<Adjustment> getAdjustments() {
        return repository.findAll();
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