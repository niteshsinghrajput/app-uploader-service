package com.nitesh.appuploaderservice.controllers;

import com.nitesh.appuploaderservice.services.AdjustmentService;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
public class AdjustmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AdjustmentService service;

    @Before
    public void setup() {

    }

}
