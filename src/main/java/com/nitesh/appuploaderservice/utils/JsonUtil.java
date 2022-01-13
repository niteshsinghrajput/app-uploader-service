package com.nitesh.appuploaderservice.utils;

import com.nitesh.appuploaderservice.models.Adjustment;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class JsonUtil {

    public List<Adjustment> parseJson() {
        List<Adjustment> adjustmentList = new ArrayList<>();
        String resourceName = "data.json";
        try {
            FileReader fr = new FileReader(resourceName);
            JSONTokener token = new JSONTokener(fr);
            JSONArray jsonArray = new JSONArray(token);
            for(Object obj: jsonArray) {
                JSONObject jsonObject = (JSONObject) obj;
                System.out.println("Adjustment ID :" + jsonObject.getLong("adjustment_id"));
                Adjustment adjustment = new Adjustment();
                adjustment.setAdjustmentId(jsonObject.getLong("adjustment_id"));
                adjustment.setAdjustmentStartDate(jsonObject.getString("adjustment_start_date"));
                adjustment.setAdjustmentEndDate(jsonObject.getString("adjustment_end_date"));
                adjustment.setAvailableForReviewer(jsonObject.getString("available_for_reviewer"));
                adjustment.setAdjustmentStatus(jsonObject.getString("adjustment_status"));
                adjustmentList.add(adjustment);
            }

        }catch (FileNotFoundException e) {

        } catch (IOException e){

        } catch (Exception e) {

        }
//        InputStream is = JsonUtil.class.getResourceAsStream(resourceName);


        return adjustmentList;
    }
}
