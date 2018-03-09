/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import javafx.geometry.VPos;
import javafx.scene.Group;
import static javafx.scene.paint.Color.WHITE;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * @author Al
 */

public class Score {
    
    private int scoreCourant;
    
    public Score () {
        scoreCourant = 0;
    }

    public int getScoreCourant() {
        return scoreCourant;
    }

    public void setScoreCourant(int scoreCourant) {
        this.scoreCourant = scoreCourant;
    }
    
    public void afficherScore(Group gp) {
        Text sc = new Text();
        sc.setText(Integer.toString(scoreCourant));
        sc.setFill(WHITE);
        sc.setX(50.0);
        sc.setY(50.0);
        //sc.setTextOrigin(VPos.TOP);
        sc.setCache(false);
        sc.setFont(Font.font("Comic sans MS",25));
        gp.getChildren().add(sc);
    }
    
    public int ajouterPoint (){
        scoreCourant ++;
        return scoreCourant;
    }
}
