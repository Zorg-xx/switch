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
import java.sql.SQLException;

/**
 *
 * @author Al
 */
public class MeilleurScore {
    
    private int meilleurScore;
    
    public MeilleurScore(){
        meilleurScore = 0;
    }

    public int getMeilleurScore() {
        return meilleurScore;
    }

    public void setMeilleurScore(int meilleurScore) {
        this.meilleurScore = meilleurScore;
    }
    
    public int majMeilleurScore(int scoreActuel){
        if (scoreActuel > meilleurScore)
            meilleurScore = scoreActuel;
        return meilleurScore;
    }
    
    public void afficherMScore(Group gp) {
        Text msc = new Text();
        msc.setText(Integer.toString(meilleurScore));
        msc.setFill(WHITE);
        msc.setX(300);
        msc.setY(300);
        msc.setCache(false);
        msc.setFont(Font.font("Arial",25));
        gp.getChildren().add(msc);
    }
 
    
    public Connection connection (){
        String url = "jdbc:sqlite:C://SqlLite/db.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    
     public void insert(String name, int meilleurSc) {
        String sql = "INSERT INTO score(name,meilleurSc ) VALUES(?,?)";
 
        try (Connection conn = this.connection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setDouble(2, meilleurSc);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    
}
