/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.demo_rest_1;

import java.util.Date;
import java.text.SimpleDateFormat;  
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Abdul
 */
public class AlienRepository 
{
    
    Date date = new Date();
    Date pred_date = new Date();
    Connection con = null;
    public String connection_1;
    public AlienRepository()
    {
        String url = "jdbc:mysql://localhost:3306/cargo_database";
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
    
    public List<Alien> getAliens()
    {
        List<Alien> aliens = new ArrayList<>();
        //SELECT * FROM cargo_database.cargo_table
        String sql = "SELECT * FROM cargo_database.cargo_table";
        //String sql = "SELECT * FROM cargo_database.cargo_table";
        try{
        Statement st = con.createStatement();
       ResultSet rs = st.executeQuery(sql);
       while(rs.next())
            {
                Alien a = new Alien();
                a.setId(rs.getInt(1));
                a.setName(rs.getString(2));
                a.setMMSI(rs.getInt(3));
                date = rs.getDate(4);
                pred_date = rs.getDate(5);

                //SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
                
                a.setDate(date.toString());
                a.setPred_date(pred_date.toString());
                
                aliens.add(a);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        
    return aliens;
    } 
    
    public Alien getAlien(int id)
    {
        
        String sql = "SELECT * FROM cargo_database.cargo_table where id="+id;
        Alien a = new Alien();
        try{
        Statement st = con.createStatement();
       ResultSet rs = st.executeQuery(sql);
       if(rs.next())
            {
                
                a.setId(rs.getInt(1));
                a.setName(rs.getString(2));
                a.setMMSI(rs.getInt(3));
                date = rs.getDate(4);
                pred_date = rs.getDate(5);

                //SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
                
                a.setDate(date.toString());
                a.setPred_date(pred_date.toString());

            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return a;  
    }

 
     public void make(Alien a1) 
    {
        String sql = "insert into cargo_database.cargo_table values (?,?,?,?,?)";
        try{
        PreparedStatement st = con.prepareStatement(sql);
        
        st.setInt(1, a1.getId());
        st.setString(2, a1.getName());
        st.setInt(3, a1.getMMSI());
        
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");  
        
        Date date1=format.parse(a1.getDate());
        Date pred_date1=format.parse(a1.getPred_date());
        
        java.sql.Date sqlDate = new java.sql.Date(date1.getTime());
        java.sql.Date sqlpredDate = new java.sql.Date(pred_date1.getTime());
        
        st.setDate(4, sqlDate);
        st.setDate(5, sqlpredDate);

        
        st.executeUpdate();
        }
        catch(Exception e){
            System.out.println(e);
        }

    }
     
    public void update(Alien a1) 
    {
        //String sql = "UPDATE `cgpa_datbase`.`student_table` SET `name` = ?, `points` =?, `date` = ? WHERE (`id` = '110');";
        String sql = "UPDATE cargo_database.cargo_table SET name = ?, MMSI =?, date = ?, pred_date = ?  WHERE id =?";
        try{
        PreparedStatement st = con.prepareStatement(sql);
        
        //st.setInt(1, a1.getId());
        st.setString(1, a1.getName());
        st.setInt(2, a1.getMMSI());
        
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        
        Date date1=format.parse(a1.getDate());
        Date pred_date1=format.parse(a1.getPred_date());
        
        java.sql.Date sqlDate = new java.sql.Date(date1.getTime());
        java.sql.Date sqlpredDate = new java.sql.Date(pred_date1.getTime());
        
        st.setDate(3, sqlDate);
        st.setDate(4, sqlpredDate);
        
        st.setInt(5, a1.getId());
        //st.setDate(4, a1.getDate());
        
        st.executeUpdate();
        }
        catch(Exception e){
            System.out.println(e);
        }

    }

    void delete(int id) {
        
        String sql = "delete from cargo_database.cargo_table WHERE id=?";
        try{
        PreparedStatement st = con.prepareStatement(sql);
        
        st.setInt(1, id);
        
        st.executeUpdate();
        }
        catch(Exception e){
            System.out.println(e);
        }
        
    }

    public String getCustomer(int id) {
        String sql = "SELECT * FROM cargo_database.cargo_table where id="+id;
        Alien a = new Alien();
        try{
        Statement st = con.createStatement();
       ResultSet rs = st.executeQuery(sql);
       if(rs.next())
            {
                
                a.setId(rs.getInt(1));
                a.setName(rs.getString(2));
                //a.setMMSI(rs.getInt(3));
                //date = rs.getDate(4);
                pred_date = rs.getDate(5);

                //SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
                
                //a.setDate(date.toString());
                a.setPred_date(pred_date.toString());

            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return pred_date.toString(); 
     
}
}
