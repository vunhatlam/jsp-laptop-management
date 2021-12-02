/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author kami
 */
public class LaptopDAO {
    Connection con = null;
    public LaptopDAO(String username, String password){
        String dbURL = "jdbc:mysql://localhost:3306/users";
        try{
            //Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(dbURL, username, password);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public boolean addLaptop(entity.Laptop laptop){
        String query = "INSERT INTO users.laptop (idpro, name, type, price, size, cpu, ram) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try{
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, laptop.getIdProducer());
            ps.setString(2, laptop.getName());
            ps.setString(3, laptop.getType());
            ps.setInt(4, laptop.getPrice());
            ps.setFloat(5, laptop.getSize());
            ps.setString(6, laptop.getCpu());
            ps.setInt(7, laptop.getRam());
            
            ps.execute();
            return true;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean deleteLaptop(int id){
        String query = "DELETE FROM users.laptop WHERE id=?";
        try{
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            
            ps.executeUpdate();
            return true;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean changeInformation(entity.Laptop laptop){
        String query = "UPDATE users.laptop SET idpro=?, name=?, type=?, price=?, size=?, cpu=?, ram=?" + " WHERE id=?";
        try{
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, laptop.getIdProducer());
            ps.setString(2, laptop.getName());
            ps.setString(3, laptop.getType());
            ps.setInt(4, laptop.getPrice());
            ps.setFloat(5, laptop.getSize());
            ps.setString(6, laptop.getCpu());
            ps.setInt(7, laptop.getRam());
            ps.setInt(8, laptop.getIdLaptop());
            
            ps.executeUpdate();
            return true;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    
    public entity.Laptop searchLaptop(int id){
        String query = "SELECT * FROM users.laptop WHERE id = '" + String.valueOf(id) + "'";
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            if(rs.next()){
                entity.Laptop laptop = new entity.Laptop();
                laptop.setIdLaptop(rs.getInt("id"));
                laptop.setIdProducer(rs.getInt("idpro"));
                laptop.setName(rs.getString("name"));
                laptop.setType(rs.getString("type"));
                laptop.setPrice(rs.getInt("price"));
                laptop.setSize(rs.getFloat("size"));
                laptop.setCpu(rs.getString("cpu"));
                laptop.setRam(rs.getInt("ram"));
                rs.close();
                return laptop;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    
    public ArrayList<entity.Laptop> searchLaptopByID(int id){
        ArrayList<entity.Laptop> list = new ArrayList<>();
        String query = "SELECT laptop.id, producer.name, laptop.name, type, price, size, cpu, ram "
                + "FROM users.laptop, users.producer WHERE (laptop.id = " + id 
                + " ) AND (laptop.idpro = producer.id)";
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                entity.Laptop laptop = new entity.Laptop();
                laptop.setIdLaptop(rs.getInt("laptop.id"));
                laptop.setProducer(rs.getString("producer.name"));
                laptop.setName(rs.getString("laptop.name"));
                laptop.setType(rs.getString("type"));
                laptop.setPrice(rs.getInt("price"));
                laptop.setSize(rs.getFloat("size"));
                laptop.setCpu(rs.getString("cpu"));
                laptop.setRam(rs.getInt("ram"));
                list.add(laptop);
            }
            return list;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    
    public ArrayList<entity.Laptop> searchByName(String s){
        ArrayList<entity.Laptop>list = new ArrayList<>();
        String query = "SELECT laptop.id, producer.name, laptop.name, type, price, size, cpu, ram "
                + "FROM users.laptop, users.producer WHERE laptop.name LIKE ('%" + s +"%') AND (laptop.idpro = producer.id) "
                + "ORDER BY laptop.price DESC";
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                entity.Laptop laptop = new entity.Laptop();
                laptop.setIdLaptop(rs.getInt("laptop.id"));
                laptop.setProducer(rs.getString("producer.name"));
                laptop.setName(rs.getString("laptop.name"));
                laptop.setType(rs.getString("type"));
                laptop.setPrice(rs.getInt("price"));
                laptop.setSize(rs.getFloat("size"));
                laptop.setCpu(rs.getString("cpu"));
                laptop.setRam(rs.getInt("ram"));
                list.add(laptop);
            }
            return list;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    
    public ArrayList<entity.Laptop> searchByProducer(String proName){
        ArrayList<entity.Laptop>list = new ArrayList<>();
        String query = "SELECT laptop.id, producer.name, laptop.name, type, price, size, cpu, ram "
                + "FROM users.laptop, users.producer WHERE producer.name LIKE ('%" + proName +"%')"
                + " AND (laptop.idpro = producer.id) ORDER BY laptop.price DESC";
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                entity.Laptop laptop = new entity.Laptop();
                laptop.setIdLaptop(rs.getInt("laptop.id"));
                laptop.setProducer(rs.getString("producer.name"));
                laptop.setName(rs.getString("laptop.name"));
                laptop.setType(rs.getString("type"));
                laptop.setPrice(rs.getInt("price"));
                laptop.setSize(rs.getFloat("size"));
                laptop.setCpu(rs.getString("cpu"));
                laptop.setRam(rs.getInt("ram"));
                list.add(laptop);
            }
            return list;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    
    public ArrayList<entity.Laptop> searchBySize(float f){
        ArrayList<entity.Laptop>list = new ArrayList<>();
        float numberA = (float)(f - 0.1);
        float numberB = (float)(f + 0.1);
        String query = "SELECT laptop.id, producer.name, laptop.name, type, price, size, cpu, ram "
                + "FROM users.laptop, users.producer WHERE (laptop.size BETWEEN " + String.valueOf(numberA) 
                + " AND " + String.valueOf(numberB) + ")  AND (laptop.idpro = producer.id) ORDER BY laptop.price DESC";
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                entity.Laptop laptop = new entity.Laptop();
                laptop.setIdLaptop(rs.getInt("laptop.id"));
                laptop.setProducer(rs.getString("producer.name"));
                laptop.setName(rs.getString("laptop.name"));
                laptop.setType(rs.getString("type"));
                laptop.setPrice(rs.getInt("price"));
                laptop.setSize(rs.getFloat("size"));
                laptop.setCpu(rs.getString("cpu"));
                laptop.setRam(rs.getInt("ram"));
                list.add(laptop);
            }
            return list;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    
    public ArrayList<entity.Laptop> searchByPriceUnder(int price){
        ArrayList<entity.Laptop>list = new ArrayList<>();
        String query = "SELECT laptop.id, producer.name, laptop.name, type, price, size, cpu, ram "
                + "FROM users.laptop, users.producer WHERE (laptop.price <= " + String.valueOf(price) 
                + ")  AND (laptop.idpro = producer.id) ORDER BY laptop.price DESC";
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                entity.Laptop laptop = new entity.Laptop();
                laptop.setIdLaptop(rs.getInt("laptop.id"));
                laptop.setProducer(rs.getString("producer.name"));
                laptop.setName(rs.getString("laptop.name"));
                laptop.setType(rs.getString("type"));
                laptop.setPrice(rs.getInt("price"));
                laptop.setSize(rs.getFloat("size"));
                laptop.setCpu(rs.getString("cpu"));
                laptop.setRam(rs.getInt("ram"));
                list.add(laptop);
            }
            return list;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    
    public ArrayList<entity.Laptop> sortPriceAscending(){
        ArrayList<entity.Laptop>list = new ArrayList<>();
        String query = "SELECT laptop.id, producer.name, laptop.name, type, price, size, cpu, ram "
                + "FROM users.laptop, users.producer WHERE laptop.idpro = producer.id ORDER BY laptop.price ASC";
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                entity.Laptop laptop = new entity.Laptop();
                laptop.setIdLaptop(rs.getInt("laptop.id"));
                laptop.setProducer(rs.getString("producer.name"));
                laptop.setName(rs.getString("laptop.name"));
                laptop.setType(rs.getString("type"));
                laptop.setPrice(rs.getInt("price"));
                laptop.setSize(rs.getFloat("size"));
                laptop.setCpu(rs.getString("cpu"));
                laptop.setRam(rs.getInt("ram"));
                list.add(laptop);
            }
            return list;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    
    public ArrayList<entity.Laptop> sortPriceDescending(){
        ArrayList<entity.Laptop>list = new ArrayList<>();
        String query = "SELECT laptop.id, producer.name, laptop.name, type, price, size, cpu, ram "
                + "FROM users.laptop, users.producer WHERE laptop.idpro = producer.id ORDER BY laptop.price DESC";
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                entity.Laptop laptop = new entity.Laptop();
                laptop.setIdLaptop(rs.getInt("laptop.id"));
                laptop.setProducer(rs.getString("producer.name"));
                laptop.setName(rs.getString("laptop.name"));
                laptop.setType(rs.getString("type"));
                laptop.setPrice(rs.getInt("price"));
                laptop.setSize(rs.getFloat("size"));
                laptop.setCpu(rs.getString("cpu"));
                laptop.setRam(rs.getInt("ram"));
                list.add(laptop);
            }
            return list;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    
    public boolean addProducer(entity.Producer producer){
        String query = "INSERT INTO users.producer (name, rate) VALUES (?, ?)";
        try{
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, producer.getName());
            ps.setFloat(2, producer.getRate());
            
            ps.execute();
            return true;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean changeProducerInformation(entity.Producer producer){
        String query = "UPDATE users.producer SET name=?, rate=?" + " WHERE id=?";
        try{
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, producer.getName());
            ps.setFloat(2, producer.getRate());
            ps.setInt(3, producer.getIdProducer());
            
            ps.executeUpdate();
            return true;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean deleteProducer(int id){
        String query1 = "DELETE FROM users.laptop WHERE idpro = ?";
        String query2 = "DELETE FROM users.producer WHERE id=?";
        try{
            PreparedStatement ps1 = con.prepareStatement(query1);
            PreparedStatement ps2 = con.prepareStatement(query2);
            ps1.setInt(1, id);
            ps2.setInt(1, id);
            
            ps1.executeUpdate();
            ps2.executeUpdate();
            return true;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    
    public ArrayList<entity.Producer> searchProducerByID(int id){
        ArrayList<entity.Producer>list = new ArrayList<>();
        String query = "SELECT * FROM users.producer WHERE producer.id = '" + id +"'";
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                entity.Producer producer = new entity.Producer();
                producer.setIdProducer(rs.getInt("producer.id"));
                producer.setName(rs.getString("producer.name"));
                producer.setRate(rs.getFloat("producer.rate"));               
                list.add(producer);
            }
            return list;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    
    public entity.Producer searchProducer(int id){
        String query = "SELECT * FROM users.producer WHERE id = '" + String.valueOf(id) + "'";
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            if(rs.next()){
                entity.Producer producer = new entity.Producer();
                producer.setIdProducer(rs.getInt("id"));
                producer.setName(rs.getString("name"));
                producer.setRate(rs.getFloat("rate"));
                
                rs.close();
                return producer;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    
    public ArrayList<entity.Producer> listProducer(){
        ArrayList<entity.Producer>list = new ArrayList<>();
        String query = "SELECT * FROM users.producer ORDER BY producer.name ASC";
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                entity.Producer producer = new entity.Producer();
                producer.setIdProducer(rs.getInt("producer.id"));
                producer.setName(rs.getString("producer.name"));
                producer.setRate(rs.getFloat("producer.rate"));               
                list.add(producer);
            }
            return list;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    
    public ArrayList<entity.Laptop> listLaptop(){
        ArrayList<entity.Laptop>list = new ArrayList<>();
        String query = "SELECT laptop.id, producer.name, laptop.name, type, price, size, cpu, ram "
                + "FROM users.laptop, users.producer WHERE producer.id=laptop.idpro ORDER BY producer.name ASC";
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                entity.Laptop laptop = new entity.Laptop();
                laptop.setIdLaptop(rs.getInt("laptop.id"));
                laptop.setProducer(rs.getString("producer.name"));
                laptop.setName(rs.getString("laptop.name"));
                laptop.setType(rs.getString("type"));
                laptop.setPrice(rs.getInt("price"));
                laptop.setSize(rs.getFloat("size"));
                laptop.setCpu(rs.getString("cpu"));
                laptop.setRam(rs.getInt("ram"));
                list.add(laptop);
            }
            return list;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    
    public ArrayList<entity.Laptop> searchBySizeAndRate(float size, float rate){
        ArrayList<entity.Laptop>list = new ArrayList<>();
        String query = "SELECT laptop.id, producer.name, laptop.name, type, price, size, cpu, ram "
                + "FROM users.laptop, users.producer WHERE (laptop.size > ceiling(" + size 
                + ")) AND (producer.rate > " + rate + ") AND (laptop.idpro = producer.id) ORDER BY laptop.price DESC";
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                entity.Laptop laptop = new entity.Laptop();
                laptop.setIdLaptop(rs.getInt("laptop.id"));
                laptop.setProducer(rs.getString("producer.name"));
                laptop.setName(rs.getString("laptop.name"));
                laptop.setType(rs.getString("type"));
                laptop.setPrice(rs.getInt("price"));
                laptop.setSize(rs.getFloat("size"));
                laptop.setCpu(rs.getString("cpu"));
                laptop.setRam(rs.getInt("ram"));
                list.add(laptop);
            }
            return list;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
