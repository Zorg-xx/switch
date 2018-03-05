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

/**
 *
 * @author Al
 */

public class Score {
    
    private int scoreCourant;
    private int meilleurScore;
    
    public Score () {
        scoreCourant = 0;
    }

    public int getScoreCourant() {
        return scoreCourant;
    }

    public int getMeilleurScore() {
        return meilleurScore;
    }

    public void setScoreCourant(int scoreCourant) {
        this.scoreCourant = scoreCourant;
    }

    public void majMeilleurScore(int scoreActuel){
        if (scoreActuel > meilleurScore)
            meilleurScore = scoreActuel;
    }
    
    public void afficherScore(Group gp) {
        Text sc = new Text();
        sc.setText(Integer.toString(scoreCourant));
        sc.setFill(WHITE);
        sc.setLayoutX(50.0);
        sc.setLayoutY(50.0);
        sc.setCache(false);
        sc.setFont(Font.font("Comic sans MS",25));
        gp.getChildren().add(sc);
    }
    
    public int ajouterPoint (){
        scoreCourant ++;
        return scoreCourant;
    }
}
