/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.demo_rest_1;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import jakarta.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Abdul
 */
public class Alien{
    private String name;
    private int Id;
    private int MMSI;
    private String date;
    private String pred_date;

    public String getPred_date() {
        return pred_date;
    }

    public void setPred_date(String pred_date) {
        this.pred_date = pred_date;
    }
    
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        
        this.Id = Id;
    }
    public String connection_1;

    public void setName(String name) {
        this.name = name;
    }

  public String getName() {
        return name;
    }
      public int getMMSI() {
        return MMSI;
    }

    public void setMMSI(int MMSI) {
        this.MMSI = MMSI;
    }



 /*   @Override
    public String toString() {
        return "Alien{" + "name=" + name + ", MMSI=" + MMSI + ", Id=" + Id + ", date=" + date + ", pred_date=" + pred_date + '}';
    }
    
  */  
    
}
