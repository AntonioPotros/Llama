/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.llama.entitites.entities;

import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
import java.sql.Connection;
import mx.itson.llama.persistence.MySQLConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author asterium
 */
public class User {

    private String name;
    private int id;
    private String phone;
    private String creditCard;
    
    public static List<User> getAll (String filtro){
        List<User> user = new ArrayList();
        try{
            Connection conexion = MySQLConnection.get();
            PreparedStatement statement = conexion.prepareStatement("SELECT id, name, phone,creditCard FROM user WHERE name LIKE ?");
            statement.setString(1, "%"+filtro+"%");
            ResultSet result = statement.executeQuery();
            while(result.next()){
                User u = new User();
                u.setId(result.getInt(1));
                u.setName(result.getString(2));
                u.setPhone(result.getString(3));
                u.setCreditCard(result.getString(4));
                user.add(u);               
            }
            
        }catch (SQLException ex){
            System.err.println("Ocurrio un error"+ex.getMessage());
        }
        return user;
    }
    public static void add(int id,String name,String phone, String creditCard){
        try{
            Connection conexion = MySQLConnection.get();
            String query = "INSERT INTO user (id,name, phone, creditCard) VALUES(?,?,?,?)";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setInt(1, id);
            statement.setString(2, name);
            statement.setString(3, phone);
            statement.setString(4, creditCard);
            statement.execute();
            
        }catch (Exception ex){
            System.err.println("Ocurrio un error"+ex.getMessage());
        }

    }
    
    public static void update(int id,String name,String phone, String creditCard){

        try{
            Connection conexion = MySQLConnection.get();
            String query = "UPDATE user SET name = ?, phone = ?, creditCard = ? where id = ?";
            PreparedStatement statement = conexion.prepareStatement(query);           
            statement.setString(1, name);
            statement.setString(2, phone);
            statement.setString(3, creditCard);
            statement.setInt(4, id);

            statement.execute();
            
        }catch (Exception ex){
            System.err.println("Ocurrio un error"+ex.getMessage());
        }

    }
    
    
    public static void delete(int id){
        try{
            Connection conexion = MySQLConnection.get();
            String query = "DELETE FROM user WHERE id = ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setInt(1, id);
            statement.execute();

            conexion.close();
            
        }catch (Exception ex){
            System.err.println("Ocurrio un error"+ex.getMessage());
        }

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
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the creditCard
     */
    public String getCreditCard() {
        return creditCard;
    }

    /**
     * @param creditCard the creditCard to set
     */
    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

}
