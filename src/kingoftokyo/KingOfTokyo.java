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
    Image logoImage; 
    
    static boolean gameStart;
    boolean win;
   
    static KingOfTokyo frame;
    
    public static void main(String[] args) {
        frame = new KingOfTokyo();
        frame.setSize(Window.WINDOW_WIDTH/3*2, Window.WINDOW_HEIGHT/2);
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
                    int xpos = e.getX()-Window.getX(0);
                    int ypos = e.getY()-Window.getY(0);
                    if (xpos>Window.getX(Window.getWidth2()/5-1) &&
                            xpos<Window.getX(Window.getWidth2()/5-1)+Window.getWidth2()/5+1&&
                            ypos>Window.getY(Window.getHeight2()/4*3-1)&&
                            ypos<Window.getY(Window.getHeight2()/4*3-1)+41){
                        
                    }
                    if(xpos>Window.getX(Window.getWidth2()/5*3-1) &&
                            xpos<Window.getX(Window.getWidth2()/5*3-1)+Window.getWidth2()/5+1&&
                            ypos>Window.getY(Window.getHeight2()/4*3-1)&&
                            ypos<Window.getY(Window.getHeight2()/4*3-1)+41){
                        
                    } 
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
                } else if (e.VK_DOWN == e.getKeyCode()){                    
                } else if (e.VK_LEFT == e.getKeyCode()){               
                } else if (e.VK_RIGHT == e.getKeyCode()){              
                } else if (e.VK_ESCAPE == e.getKeyCode()){

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
        g.setColor(new Color(3, 85, 184));
        g.fillRect(0, 0, Window.xsize, Window.ysize);

        int x[] = {Window.getX(0), Window.getX(Window.getWidth2()), Window.getX(Window.getWidth2()), Window.getX(0), Window.getX(0)};
        int y[] = {Window.getY(0), Window.getY(0), Window.getY(Window.getHeight2()), Window.getY(Window.getHeight2()), Window.getY(0)};
//fill border
        g.setColor(Color.WHITE);
        g.fillPolygon(x, y, 4);
//draw border
        g.setColor(new Color(252, 203, 7));
        g.drawPolyline(x, y, 5);

        if (animateFirstTime) {
            gOld.drawImage(image, 0, 0, null);
            return;
        }  
        if (!gameStart){
            g.drawImage(logoImage,Window.getX(0),Window.getY(0)-115,
                Window.getWidth2(),Window.getHeight2()*2-50,this);
            
            g.setColor(new Color(245,150,7));
            g.drawRect(Window.getX(Window.getWidth2()/5-1),Window.getY(Window.getHeight2()/4*3-1),
                Window.getWidth2()/5+1, 41);   
            g.drawRect(Window.getX(Window.getWidth2()/5*3-1), Window.getY(Window.getHeight2()/4*3-1),
                Window.getWidth2()/5+1, 41);   
            g.setColor(new Color(247,202,49));
            g.fillRect(Window.getX(Window.getWidth2()/5),Window.getY(Window.getHeight2()/4*3),
                Window.getWidth2()/5, 40);
            g.fillRect(Window.getX(Window.getWidth2()/5*3), Window.getY(Window.getHeight2()/4*3),
                Window.getWidth2()/5, 40);
            g.setColor(Color.black);
            g.setFont(new Font("Impact",Font.PLAIN,15));
            g.drawString("Start Game",Window.getX(Window.getWidth2()/5+3),Window.getY(Window.getHeight2()/4*3+25));
            g.drawString("Instructions",Window.getX(Window.getWidth2()/5*3+1),Window.getY(Window.getHeight2()/4*3+25));
        }
        else if (gameStart){
            g.drawImage(boardImage,Window.getX(0)*8,Window.getY(0)*3,
                Window.getWidth2()/2,Window.getHeight2()/2,this);
        
            if (win)
            {
                g.setColor(new Color(252,203,7));
                g.setFont(new Font("Impact",Font.PLAIN,45));
                g.drawString("You are the King of Tokyo!",65,325);
            }
        
            g.drawImage(boardImage,Window.getX(0)*8,Window.getY(0)*3,
                    Window.getWidth2()/2,Window.getHeight2()/2,this); 

            Drawing.drawMonsterInfoBox(Window.getX(0)*8, Window.getY(0)*3);

            Drawing.drawVictoryPoints(250,235,180.0,1.0,1.0);

            Drawing.drawHealthPoints(350,235,180.0,0.65,0.65);

            if (win)
            {
                g.setColor(Color.black);
                g.setFont(new Font("Arial",Font.PLAIN,45));
                g.drawString("You are the King of Tokyo!",65,325);
            }         
        
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
            logoImage = Toolkit.getDefaultToolkit().getImage("./logo.png");  
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
