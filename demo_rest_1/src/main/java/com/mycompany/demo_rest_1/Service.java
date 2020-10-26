/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.demo_rest_1;

/**
 *
 * @author Abdul
 */
public class Service {
            private int MMSI;
            private float lat_loc;
            private float long_loc;
            private String prev_port;
            private String next_port;
            private String pred_dtm;
            private String plan_dtm;

    public int getMMSI() {
        return MMSI;
    }

    public void setMMSI(int MMSI) {
        this.MMSI = MMSI;
    }

    public float getLat_loc() {
        return lat_loc;
    }

    public void setLat_loc(float lat_loc) {
        this.lat_loc = lat_loc;
    }

    public float getLong_loc() {
        return long_loc;
    }

    public void setLong_loc(float long_loc) {
        this.long_loc = long_loc;
    }

    public String getPrev_port() {
        return prev_port;
    }

    public void setPrev_port(String prev_port) {
        this.prev_port = prev_port;
    }

    public String getNext_port() {
        return next_port;
    }

    public void setNext_port(String next_port) {
        this.next_port = next_port;
    }

    public String getPred_dtm() {
        return pred_dtm;
    }

    public void setPred_dtm(String pred_dtm) {
        this.pred_dtm = pred_dtm;
    }

    public String getPlan_dtm() {
        return plan_dtm;
    }

    public void setPlan_dtm(String plan_dtm) {
        this.plan_dtm = plan_dtm;
    }
}
