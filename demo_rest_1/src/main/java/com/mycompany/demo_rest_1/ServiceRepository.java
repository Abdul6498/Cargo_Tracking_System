/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.demo_rest_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Abdul
 */
public class ServiceRepository {
    
    
    Connection con = null;
    
    public ServiceRepository()
    {
        String url = "jdbc:mysql://localhost:3306/Cargo_mdl";
        //String url = "jdbc:mysql://localhost:3306/cargo_databasee";
        String username = "root";
        String password = "6498";
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);
        
        }
        catch(Exception e)
        {
            System.out.println(e);
        
        }
        
    }
    public Service getAlien(int id)
    {
        
        String sql = "SELECT * FROM Cargo_mdl.data_ser where id="+id;
        Service a = new Service();
        try{
        Statement st = con.createStatement();
       ResultSet rs = st.executeQuery(sql);
       if(rs.next())
            {
                
                a.setMMSI(rs.getInt(1));

            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return a;
    }

 
     public void make(Service a1) 
    {
        String sql = "insert into Cargo_mdl.data_ser values (?,?,?,?,?,?,?)";
        try{
        PreparedStatement st = con.prepareStatement(sql);
        
        st.setInt(1, a1.getMMSI());
        st.setFloat(2, a1.getLat_loc());
        st.setFloat(3, a1.getLong_loc());
        st.setString(4, a1.getPrev_port());
        st.setString(5, a1.getNext_port());
        
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");  
        
        Date date1=format.parse(a1.getPred_dtm());
        Date pred_date1=format.parse(a1.getPlan_dtm());
        
        java.sql.Date sqlDate = new java.sql.Date(date1.getTime());
        java.sql.Date sqlpredDate = new java.sql.Date(pred_date1.getTime());
        
        st.setDate(6, sqlDate);
        st.setDate(7, sqlpredDate);

        
        st.executeUpdate();
        }
        catch(Exception e){
            System.out.println(e);
        }

    }
     
    public void update(Service a1) 
    {
        //String sql = "UPDATE `cgpa_datbase`.`student_table` SET `name` = ?, `points` =?, `date` = ? WHERE (`id` = '110');";
        String sql = "UPDATE Cargo_mdl.data_ser SET lat_loc = ?, long_loc =?, prev_port = ?, next_port = ?, pred_dtm = ?, plan_dtm = ?  WHERE mmsi_id =?";
        try{
        PreparedStatement st = con.prepareStatement(sql);
        
        //st.setInt(1, a1.getId());
        st.setFloat(1, a1.getLat_loc());
        st.setFloat(2, a1.getLong_loc());
        st.setString(3, a1.getPrev_port());
        st.setString(4, a1.getNext_port());
        
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");  
        
        Date date1=format.parse(a1.getPred_dtm());
        Date pred_date1=format.parse(a1.getPlan_dtm());
        
        java.sql.Date sqlDate = new java.sql.Date(date1.getTime());
        java.sql.Date sqlpredDate = new java.sql.Date(pred_date1.getTime());
        
        st.setDate(5, sqlDate);
        st.setDate(6, sqlpredDate);
        st.setInt(7, a1.getMMSI());
        //st.setDate(4, a1.getDate());
        
        st.executeUpdate();
        }
        catch(Exception e){
            System.out.println(e);
        }

    }
}
