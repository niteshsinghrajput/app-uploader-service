package com.nitesh.appuploaderservice.services;

import com.nitesh.appuploaderservice.models.Adjustment;
import com.nitesh.appuploaderservice.repositories.AdjustmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdjustmentServiceImpl implements AdjustmentService {

    @Autowired
    private AdjustmentRepository repository;

    @Override
    public List<Adjustment> saveAdjustments(List<Adjustment> adjustments) {
        return null;
    }

    @Override
    public Adjustment saveAdjustment(Adjustment adjustment) {
        return null;
        //return repository.save(adjustment);
    }


}