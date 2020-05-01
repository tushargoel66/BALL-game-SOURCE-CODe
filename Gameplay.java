
package ballgame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import javax.swing.JPanel;
import javax.swing.Timer;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class Gameplay extends JPanel implements ActionListener,KeyListener {
    
    private Timer timer;
    private int ballXPos=120;
    private int ballYPos=350;
    private int ballXDir=-1;
    private int ballYDir=-2;
    private int score=0;
    private int posX=310;
    private int delay=8;
    private boolean play=false;
    private String level="1";
    
    
    public void paint(Graphics g){
        
        g.setColor(Color.black);
        g.fillRect(0, 0, 640, 580);
        g.setColor(Color.red);
        g.drawRect(0, 0, 633, 451);
        
        //code for the hitter
        
        g.setColor(Color.cyan);
        g.fillRect(posX, 442, 150, 6);
        
        //code for the ball
       
        g.setColor(Color.MAGENTA);
        g.fillOval(ballXPos, ballYPos, 20, 20);
        
        //score projection
        
        g.setColor(Color.orange);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
        g.drawString("Score : "+score, 20, 510);
        //level projection
        g.setColor(Color.orange);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
        g.drawString("Level : "+level, 450, 510);
        
        
        
        g.dispose();
    }
    
    Gameplay() throws Exception{
        addKeyListener((KeyListener) this);
        setFocusTraversalKeysEnabled(true);
        setFocusable(true);
        setSize(640,580);
        timer =new Timer(delay, (ActionListener) this);
        timer.start();
    } 

    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();
        repaint();
        if(play){
            if(ballXPos<0)
                ballXDir*=-1;
            if(ballYPos<0)
                ballYDir*=-1;
            if(ballXPos>630)
                ballXDir*=-1;
            if(ballYDir>470)
                ballYDir*=-1;
            ballXPos+=ballXDir;
            ballYPos+=ballYDir;
        }
        
        if(new Rectangle(ballXPos,ballYPos,20,20).intersects(new Rectangle(posX,442,150,6))){
            ballYDir*=-1;
            score++;
        } 
        if(score==6){
            if(ballXDir<0)
                ballXDir=-2;
            else 
                ballXDir=2;
            level="2";
        }
        if(score==15){
            if(ballXDir<0)
                ballXDir=-4;
            else 
                ballXDir=4;
            level="3";
        }
        if(score==30){
            if(ballXDir<0)
                ballXDir=-5;
            else 
                ballXDir=5;
            level="4";
        }
        if(score==40){
            if(ballXDir<0)
                ballXDir=-6;
            else 
                ballXDir=6;
            level="MAXIMUM";
        }
        
        if(ballYPos>430||score==50){
            ballXPos=120;
            ballYPos=350;
            posX=310;
            ballXDir=-1;
            ballYDir=-2;
            score=0;
            level="1";
            play=false; 
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()== KeyEvent.VK_RIGHT){
            if(posX>480)
                posX=480;
            else
                moveRight();
        }
        if(e.getKeyCode()== KeyEvent.VK_LEFT){
            if(posX<10)
                posX=10;
            else
                moveLeft();
        }
        
    }

    private void moveRight(){
        play=true;
        posX+=20;
        
    }
    
    
    private void moveLeft(){
        play=true;
        posX-=20;
    }
    
    
    @Override
    public void keyReleased(KeyEvent e) {}
    
    
    
}
