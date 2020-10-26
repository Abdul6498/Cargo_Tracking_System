/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Abdul
 */
package com.mycompany.demo_rest_1;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

 

public class Service_Loc {
		
/*     public static void main(String[] args) {
     try {
         Service_Loc.call_me();
        } catch (Exception e) {
         e.printStackTrace();
       }
     }
     
	   
public static void call_me() throws Exception {
     String url = "http://.../...&format=json";
     URL obj = new URL(url);
     HttpURLConnection con = (HttpURLConnection) obj.openConnection();
     con.setRequestMethod("GET");
     con.setRequestProperty("Root", "Mozilla/Version");
     int responseCode = con.getResponseCode();
     BufferedReader in = new BufferedReader(
             new InputStreamReader(con.getInputStream()));
     String inputLine;
     StringBuffer response = new StringBuffer();
     while ((inputLine = in.readLine()) != null) {
     	response.append(inputLine);
     }
     in.close();
     //Data will be stored in String buffer after that we can conver string to json objects
   }
*/
     Connection con = null;
public void readjson() {

        JSONParser parser = new JSONParser();
        ServiceRepository repo = new ServiceRepository();
        Service a1 = new Service();

        try (Reader reader = new FileReader("/test.json")) {

            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            //System.out.println(jsonObject);

            int MMSI = (int) jsonObject.get("MMSI_id");
            a1.setMMSI(MMSI);
            float lat_loc = (float) jsonObject.get("lat_loc");
            a1.setLat_loc(lat_loc);
            float long_loc = (float) jsonObject.get("long_loc");
            a1.setLat_loc(lat_loc);
            String prev_port = (String) jsonObject.get("prev_port");
            a1.setPrev_port(prev_port);
            String next_port = (String) jsonObject.get("next_port");
            a1.setNext_port(next_port);
            String pred_dtm = (String) jsonObject.get("pred_dtm");
            a1.setPred_dtm(pred_dtm);
            String plan_dtm = (String) jsonObject.get("plan_dtm");
            a1.setPlan_dtm(plan_dtm);
            
        
        if(repo.getAlien(a1.getMMSI()).getMMSI() == 0)
        {
            //message = "{\"message\":\"" + "Data not found" + "\"}";
            repo.make(a1);
        }
        else
        {
        repo.update(a1);
        }
        
        

            

        } catch (IOException e) {
            System.out.println(e);
        } catch (ParseException e) {
            System.out.println(e);
        }

    }
}

    

