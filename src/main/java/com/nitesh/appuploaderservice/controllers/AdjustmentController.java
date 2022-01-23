package com.nitesh.appuploaderservice.controllers;

import com.nitesh.appuploaderservice.models.Adjustment;
import com.nitesh.appuploaderservice.services.AdjustmentService;
import com.nitesh.appuploaderservice.utils.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@CrossOrigin
@RestController
public class AdjustmentController {

    @Autowired
    private AdjustmentService adjustmentService;

    @GetMapping("adjustments")
    public List<Adjustment> getAdjustments() {
        return adjustmentService.getAdjustments();
    }

    @PostMapping("adjustments")
    public List<Adjustment> createAdjustments(@RequestBody List<Adjustment> adjustments) {
        return adjustmentService.saveAdjustments(adjustments);
    }

    @PostMapping("upload-adjustments")
    public ResponseEntity<String> uploadDsrBsnlFile(@RequestParam("file") MultipartFile file) {

        String UPLOADED_FOLDER = "./adjustment_data/";
        if(file.isEmpty()) {
            return new ResponseEntity<String>("Please Select a File to Upload", HttpStatus.BAD_REQUEST);
        }
        try {

            InputStream in = file.getInputStream();
            Path path = Paths.get(UPLOADED_FOLDER);
            String fileLocation = path +"/"+ file.getOriginalFilename();
            FileOutputStream f = new FileOutputStream(fileLocation);
            int ch = 0;
            while ((ch = in.read()) != -1) {
                f.write(ch);
            }
            f.flush();
            f.close();

            File excelFile = new File(fileLocation);
            List<Adjustment> adjustments = ExcelUtil.readExcelData(excelFile);
            System.out.println("adjustments : " + adjustments);
            boolean status = true; //service.saveDsrBsnl(dsrBsnlDataList);
            if(status) {
                return new ResponseEntity<String>("File ["+ file.getOriginalFilename() +"] has been uploaded Successfully", HttpStatus.OK);
            }

        } catch(Exception e) {
            System.out.println("error occurred "+ e);
            e.printStackTrace();
        }

        return new ResponseEntity<String>("Problem occured while uploading file", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
