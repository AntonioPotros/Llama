/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.llama.entitites.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mx.itson.llama.enums.Type;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import mx.itson.llama.persistence.MySQLConnection;

/**
 *
 * @author asterium
 */
public class Movie {



 private int id;
 private String name;
 private String date;
 private String type;
 private String schedule;
private int room;
private int seat;

 
 public static List<Movie> getAll(String filtro){
     List<Movie> movies = new ArrayList();
     try{
         Connection conexion = MySQLConnection.get();
         PreparedStatement statement = conexion.prepareStatement("SELECT id,name, type, schedule, room FROM movie where name LIKE ?" );
         statement.setString(1, "%"+filtro+"%");
         ResultSet result = statement.executeQuery();
         while(result.next()){
             Movie m = new Movie();
             m.setId(result.getInt(1));
             m.setName(result.getString(2));
            m.setType(result.getString(3));
             m.setSchedule(result.getString(4));
             m.setRoom(result.getInt(5));
             
             movies.add(m);
         }
     }catch(SQLException ex){
         System.out.println("Ocurrio un error"+ex.getMessage());
     }
     return movies;
 }
 public static void add( int id,String name,String type, String schedule,int room){
     try{
     Connection conexion = MySQLConnection.get();
     String query = "INSERT INTO movie (id, name, type, schedule,room) VALUES(?,?,?,?,?)";
     PreparedStatement statement = conexion.prepareStatement(query);
     statement.setInt(1, id);
     statement.setString(2, name);
     statement.setString(3, type);
     statement.setString(4, schedule);
     statement.setInt(5, room);
     
     statement.execute();
     }catch(Exception ex){
         System.out.println("Ocurrio un error"+ex.getMessage());
     }
 }
 
 public static void delete(int id){
     try{
         Connection conexion = MySQLConnection.get();
         String query = "DELETE FROM movie WHERE id = ?";
         PreparedStatement statement = conexion.prepareStatement(query);
         statement.setInt(1, id);
         statement.execute();

     }catch(Exception ex){
         System.out.println("Ocurrio un error"+ex.getMessage());
     }
 }
 public static void update(int id,String name,String type, String schedule,int room ){
     try{
     Connection conexion = MySQLConnection.get();
     String query = "UPDATE movie SET name = ?, type = ?, schedule = ?, room = ? WHERE id = ? ";
     PreparedStatement statement = conexion.prepareStatement(query);
     
     statement.setString(1, name);
     statement.setString(2, type);
     statement.setString(3, schedule);
     statement.setInt(4, room);
     statement.setInt(5, id);

     statement.execute();
     
     }catch(Exception ex){
         System.out.println("Ocurrio un error"+ex.getMessage());
     }
         
 }
 
 
     /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }
 

        /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }



    /**
     * @return the schedule
     */
    public String getSchedule() {
        return schedule;
    }

    /**
     * @param schedule the schedule to set
     */
    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    
    /**
     * @return the room
     */
    public int getRoom() {
        return room;
    }

    /**
     * @param room the room to set
     */
    public void setRoom(int room) {
        this.room = room;
                }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
        /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
       /**
     * @return the seat
     */
    public int getSeat() {
        return seat;
    }

    /**
     * @param seat the seat to set
     */
    public void setSeat(int seat) {
        this.seat = seat;
    }
    
}
