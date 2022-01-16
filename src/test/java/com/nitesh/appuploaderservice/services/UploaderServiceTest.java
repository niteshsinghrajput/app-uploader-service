package com.nitesh.appuploaderservice.services;

import com.nitesh.appuploaderservice.models.Adjustment;
import com.nitesh.appuploaderservice.repositories.AdjustmentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.util.Assert;

import java.util.Date;

@RunWith(MockitoJUnitRunner.class)
public class UploaderServiceTest {

    @Mock
    AdjustmentRepository repository;

    @InjectMocks
    AdjustmentServiceImpl service;

    @Test
    public void createAdjustmentTest() {
        Adjustment adjustment = new Adjustment();
        adjustment.setAdjustmentId(101);
        adjustment.setAdjustmentStatus("DRAFT");
        adjustment.setAvailableForReviewer("true");
        adjustment.setAdjustmentStartDate(new Date("2022-01-01"));
        adjustment.setAdjustmentEndDate(new Date("2022-01-05"));
       // Mockito.when(repository.save(Mockito.any(Adjustment.class))).thenReturn(new Adjustment());
        Adjustment createdAdjustment = service.saveAdjustment(adjustment);
        Assert.hasText(adjustment.getAdjustmentStatus(), createdAdjustment.getAdjustmentStatus());
    }


}
