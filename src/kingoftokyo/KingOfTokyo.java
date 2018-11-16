package kingoftokyo;

import java.io.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*; 
import java.io.File;
import java.util.ArrayList;

public class KingOfTokyo extends JFrame implements Runnable {
 
    boolean animateFirstTime = true;
    Image image;
    Graphics2D g;
    
    Image boardImage; 
    Image alienoidToken; 
    Image cyberKittyToken; 
    Image gigazaurToken; 
    Image mekaDragonToken;
    boolean win;
   
    static KingOfTokyo frame;
    
    public static void main(String[] args) {
        frame = new KingOfTokyo();
        frame.setSize(Window.WINDOW_WIDTH, Window.WINDOW_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public KingOfTokyo() {
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
              
                if (win)
                    return;
                
                if (e.BUTTON1 == e.getButton() ) {
                    e.getX();
                    e.getY();
                    win = Board.CheckWin();
                }

                if (e.BUTTON3 == e.getButton()) { 
                    e.getX(); 
                    e.getY();  
                }
                repaint();
            }
        });
            

    addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseDragged(MouseEvent e) {

        repaint();
      }
    });

    addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseMoved(MouseEvent e) {

        repaint();
      }
    });

        addKeyListener(new KeyAdapter() {

            public void keyPressed(KeyEvent e) {
                if (e.VK_UP == e.getKeyCode()) { 
                } else if (e.VK_DOWN == e.getKeyCode()) {                     
                } else if (e.VK_LEFT == e.getKeyCode()) {                     
                } else if (e.VK_RIGHT == e.getKeyCode()) {                     
                } else if (e.VK_ESCAPE == e.getKeyCode()) {
                    reset();
                }
                repaint();
            }
        });
        init();
        start();
    }
    Thread relaxer;
////////////////////////////////////////////////////////////////////////////
    public void init() {
        requestFocus();
    }
////////////////////////////////////////////////////////////////////////////
    public void destroy() {
    }
////////////////////////////////////////////////////////////////////////////
    public void paint(Graphics gOld) {
        if (image == null || Window.xsize != getSize().width || Window.ysize != getSize().height) {
            Window.xsize = getSize().width;
            Window.ysize = getSize().height;
            image = createImage(Window.xsize, Window.ysize);
            g = (Graphics2D) image.getGraphics(); 
            Drawing.setDrawingInfo(g,this);
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
        }
//fill background
        
        g.setColor(Color.cyan);
        g.fillRect(0, 0, Window.xsize, Window.ysize);

        int x[] = {Window.getX(0), Window.getX(Window.getWidth2()), Window.getX(Window.getWidth2()), Window.getX(0), Window.getX(0)};
        int y[] = {Window.getY(0), Window.getY(0), Window.getY(Window.getHeight2()), Window.getY(Window.getHeight2()), Window.getY(0)};
//fill border
        g.setColor(Color.white);
        g.fillPolygon(x, y, 4);
// draw border
        g.setColor(Color.red);
        g.drawPolyline(x, y, 5);

        if (animateFirstTime) {
            gOld.drawImage(image, 0, 0, null);
            return;
        }  
        
        g.drawImage(boardImage,Window.getX(0)*8,Window.getY(0)*3,
                Window.getWidth2()/2,Window.getHeight2()/2,this); 
        
        g.drawImage(alienoidToken,Window.getX(0)*8,Window.getY(0)*3,
                Window.getWidth2()/2,Window.getHeight2()/2,this); 
        
        g.drawImage(cyberKittyToken,Window.getX(0)*8,Window.getY(0)*3,
                Window.getWidth2()/2,Window.getHeight2()/2,this); 
        
        g.drawImage(gigazaurToken,Window.getX(0)*8,Window.getY(0)*3,
                Window.getWidth2()/2,Window.getHeight2()/2,this); 
        
        g.drawImage(mekaDragonToken,Window.getX(0)*8,Window.getY(0)*3,
                Window.getWidth2()/2,Window.getHeight2()/2,this);
 
        if(Monster.getNumPlayers() == 2){ 
            Drawing.drawMonsterInfoBox(Window.getX(0)*1,Window.getY(0)*6,50,445,180.0,1.0,1.0,0,120,445,180.0,0.65,0.65,10,175,448,1.25,1.25,0);
        
//        Drawing.drawMonsterInfoBox(Window.getX(0)*23,Window.getY(0)*6,668,445,180.0,1.0,1.0,0,0,0,0,738,445,180.0,0.65,0.65,10,10,10,10,788,448,1.25,1.25,0,0,0,0); 
            Drawing.drawMonsterInfoBox(Window.getX(0)*23,Window.getY(0)*6,668,445,180.0,1.0,1.0,0,738,445,180.0,0.65,0.65,10,788,448,1.25,1.25,0);
        } 
        
        else if(Monster.getNumPlayers() == 3){
            Drawing.drawMonsterInfoBox(Window.getX(0)*1,Window.getY(0)*6,50,445,180.0,1.0,1.0,0,120,445,180.0,0.65,0.65,10,175,448,1.25,1.25,0);
        
//        Drawing.drawMonsterInfoBox(Window.getX(0)*23,Window.getY(0)*6,668,445,180.0,1.0,1.0,0,0,0,0,738,445,180.0,0.65,0.65,10,10,10,10,788,448,1.25,1.25,0,0,0,0); 
        
//        Drawing.drawMonsterInfoBox(Window.getX(0)*12,Window.getY(0)*2,359,165,180.0,1.0,1.0,0,0,0,0,429,165,180.0,0.65,0.65,10,10,10,10,479,168,1.25,1.25,0,0,0,0);
        } 
        
        else{
            Drawing.drawMonsterInfoBox(Window.getX(0)*1,Window.getY(0)*6,50,445,180.0,1.0,1.0,0,120,445,180.0,0.65,0.65,10,175,448,1.25,1.25,0);
        
//        Drawing.drawMonsterInfoBox(Window.getX(0)*23,Window.getY(0)*6,668,445,180.0,1.0,1.0,0,0,0,0,738,445,180.0,0.65,0.65,10,10,10,10,788,448,1.25,1.25,0,0,0,0); 
        
//        Drawing.drawMonsterInfoBox(Window.getX(0)*12,Window.getY(0)*2,359,165,180.0,1.0,1.0,0,0,0,0,429,165,180.0,0.65,0.65,10,10,10,10,479,168,1.25,1.25,0,0,0,0); 
        
//        Drawing.drawMonsterInfoBox(Window.getX(0)*12,Window.getY(0)*10,359,725,180.0,1.0,1.0,0,0,0,0,429,725,180.0,0.65,0.65,10,10,10,10,484,728,1.25,1.25,0,0,0,0);
        } 
        
        Drawing.drawRollButton();
        
        if (win)
        {
            g.setColor(Color.black);
            g.setFont(new Font("Arial",Font.PLAIN,45));
            g.drawString("You are the King of Tokyo!",65,325);
        }         
        
        gOld.drawImage(image, 0, 0, null);
    }

////////////////////////////////////////////////////////////////////////////
// needed for     implement runnable
    public void run() {
        while (true) {
            animate();
            repaint();
            double seconds = .1;    //time that 1 frame takes.
            int miliseconds = (int) (1000.0 * seconds);
            try {
                Thread.sleep(miliseconds);
            } catch (InterruptedException e) {
            }
        }
    }
    
/////////////////////////////////////////////////////////////////////////
    public void reset() {
    }
/////////////////////////////////////////////////////////////////////////
    public void animate() {
        if (animateFirstTime) {
            animateFirstTime = false;
            if (Window.xsize != getSize().width || Window.ysize != getSize().height) {
                Window.xsize = getSize().width;
                Window.ysize = getSize().height;
            }            
            boardImage = Toolkit.getDefaultToolkit().getImage("./board.jpg");  
            alienoidToken = Toolkit.getDefaultToolkit().getImage("./AL Player Token.png"); 
            cyberKittyToken = Toolkit.getDefaultToolkit().getImage("./CK Player Token.png");
            gigazaurToken = Toolkit.getDefaultToolkit().getImage("./GZ Player Token.png"); 
            mekaDragonToken = Toolkit.getDefaultToolkit().getImage("./MD Player Token.png");
            reset();

        }

        
    }

////////////////////////////////////////////////////////////////////////////
    public void start() {
        if (relaxer == null) {
            relaxer = new Thread(this);
            relaxer.start();
        }
    }
////////////////////////////////////////////////////////////////////////////
    public void stop() {
        if (relaxer.isAlive()) {
            relaxer.stop();
        }
        relaxer = null;
    } 
}

