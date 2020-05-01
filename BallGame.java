
package ballgame;

import java.io.File;
import java.io.FileInputStream;
import javafx.scene.media.*;
import javax.swing.JFrame;


public class BallGame {

    public static void main(String[] args) {
        JFrame jf=new JFrame();
        jf.setTitle("Welcome!! to a game by TUSHAR GOEL");
        jf.setSize(640,580);
        jf.setResizable(false);
        Gameplay g=new Gameplay();
        jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
        jf.setVisible(true);
        jf.add(g);
        
    
    }
}
