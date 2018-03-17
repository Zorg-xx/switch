/*
  * To change this license header, choose License Headers in Project Properties.
  * To change this template file, choose Tools | Templates
  * and open the template in the editor.
  */
 package modele;
 
 import javafx.scene.Group;
 import static javafx.scene.paint.Color.WHITE;
 import javafx.scene.text.Font;
 import javafx.scene.text.Text;
 import java.sql.Connection;
 import java.sql.DriverManager;
 import java.sql.PreparedStatement;
 import java.sql.ResultSet;
 import java.sql.SQLException;
 
 /**
  *
  * @author Al
  */
 public class MeilleurScore {
     
     private int meilleurScore;
     private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
     
    public MeilleurScore(){
        meilleurScore = 0;
    }
 
    public int getMeilleurScore() {
        return meilleurScore;
    }
 
    public void setMeilleurScore(int meilleurScore) {
        this.meilleurScore = meilleurScore;
    }
     
    public void majMeilleurScore(int scoreActuel){
        if (scoreActuel > meilleurScore){
            meilleurScore = scoreActuel;
            insert(this.name, meilleurScore); 
        }
    }
     
    public void afficherMScore(Group gp) {
        Text msc = new Text();
        msc.setText(Integer.toString(meilleurScore));
        msc.setText(Integer.toString(maxiScore(this.name)));
        msc.setFill(WHITE);
        msc.setX(300);
        msc.setY(300);
        msc.setCache(false);
        msc.setFont(Font.font("Arial",25));
        gp.getChildren().add(msc);
    }
  
     
    public Connection connection (){
        String url = "jdbc:sqlite:C://SqlLite/Db/db.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
     
    public void intiMS (){
        String req = "CREATE TABLE IF NOT EXISTS score (id integer PRIMARY KEY, name text, score integer);";
        try(Connection con = this.connection();
            PreparedStatement pstmt = con.prepareStatement(req)) {
            pstmt.execute();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void insert(String name, int meilleurSc) {
        String sql = "INSERT INTO score(name,meilleurSc ) VALUES(?,?);";
        try (Connection conn = this.connection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setDouble(2, meilleurSc);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
     
    public int maxiScore (String name){
        String req = "SELECT * from score where name = ? " + "and meilleurSc in (select max(meilleurSc) from score);" ;
        int res = 0;
        try(Connection con = this.connection();
            PreparedStatement pstmt = con.prepareStatement(req)) {
            pstmt.setString(1, name);
            ResultSet ms  = pstmt.executeQuery();
            res = ms.getInt(1);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return res;
    }
     
     
 }