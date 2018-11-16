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
    
<<<<<<< Updated upstream
    Image boardImage; 
    Image alienoidToken; 
    Image cyberKittyToken; 
    Image gigazaurToken; 
    Image mekaDragonToken;
    boolean win;
=======
    Image logoImage; 
    
    static boolean gameStart;
    static boolean choosingChar;
    static boolean showInstruct;
    static boolean win;
    
    static int backingX;
    static int backingY;
    static boolean showBacking;
>>>>>>> Stashed changes
   
    static KingOfTokyo frame;
    
    public static void main(String[] args) {
        frame = new KingOfTokyo();
<<<<<<< Updated upstream
        frame.setSize(Window.WINDOW_WIDTH, Window.WINDOW_HEIGHT);
=======
        frame.setSize(Window.WINDOW_WIDTH/2, Window.WINDOW_HEIGHT/5*2);
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
                    e.getX();
                    e.getY();
                    win = Board.CheckWin();
=======
                    int xpos = e.getX();
                    int ypos = e.getY();
                    if (!gameStart){
                        if (showInstruct){
                            choosingChar=true;
                        }
                        if (!choosingChar && xpos > Window.getX(Window.getWidth2()/5) && xpos < Window.getX(Window.getWidth2()/5)+Window.getWidth2()/5 &&
                            ypos > Window.getY(Window.getHeight2()/4*3) && ypos < Window.getY(Window.getHeight2()/4*3)+40)                
                                choosingChar=true;   
                        else{
                            if (xpos>Window.getX(Window.getWidth2()/4-25)&&xpos<Window.getX(Window.getWidth2()/4)+10
                                &&ypos>Window.getY(Window.getHeight2()/2-15)&&ypos<Window.getY(Window.getHeight2()/2)+23){
                                frame.setVisible(false);
                                frame = new KingOfTokyo();
                                frame.setSize(Window.WINDOW_WIDTH, Window.WINDOW_HEIGHT);
                                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                frame.setLocationRelativeTo(null);
                                frame.setResizable(false);
                                frame.setVisible(true);
                                showBacking=false;
                                gameStart=true;
                                Monster.createPlayers(2);
                            }
                            else if(xpos>Window.getX(Window.getWidth2()/2-25)&&xpos<Window.getX(Window.getWidth2()/2)+10
                                &&ypos>Window.getY(Window.getHeight2()/2-15)&&ypos<Window.getY(Window.getHeight2()/2)+23){
                                frame.setVisible(false);
                                frame = new KingOfTokyo();
                                frame.setSize(Window.WINDOW_WIDTH, Window.WINDOW_HEIGHT);
                                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                frame.setLocationRelativeTo(null);
                                frame.setResizable(false);
                                frame.setVisible(true);
                                showBacking=false;
                                gameStart=true;
                                Monster.createPlayers(3);
                            }else if(xpos>Window.getX(Window.getWidth2()/4*3-25)&&xpos<Window.getX(Window.getWidth2()/4*3)+10
                                &&ypos>Window.getY(Window.getHeight2()/2-15)&&ypos<Window.getY(Window.getHeight2()/2)+23){
                                frame.setVisible(false);
                                frame = new KingOfTokyo();
                                frame.setSize(Window.WINDOW_WIDTH, Window.WINDOW_HEIGHT);
                                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                frame.setLocationRelativeTo(null);
                                frame.setResizable(false);
                                frame.setVisible(true);
                                showBacking=false;
                                gameStart=true;
                                Monster.createPlayers(4);
                            }
                        }
                    if (xpos > Window.getX(Window.getWidth2()/5*3) && xpos < Window.getX(Window.getWidth2()/5*3)+Window.getWidth2()/5 &&
                        ypos > Window.getY(Window.getHeight2()/4*3) && ypos < Window.getY(Window.getHeight2()/4*3)+40){
                        frame.setVisible(false);
                        frame = new KingOfTokyo();
                        frame.setSize(Window.WINDOW_WIDTH, Window.WINDOW_HEIGHT);
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame.setLocationRelativeTo(null);
                        frame.setResizable(false);
                        frame.setVisible(true);
                        
                        showInstruct=true;
                    }
                    
>>>>>>> Stashed changes
                }
                win = Monster.CheckWin();
                if (e.BUTTON3 == e.getButton()) { 
                    e.getX(); 
                    e.getY();  
                }
                repaint();
            }
        }
    });
            

    addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseDragged(MouseEvent e) {
        
        repaint();
      }
    });

    addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseMoved(MouseEvent e) {
        int xpos = e.getX();
        int ypos = e.getY();
        if (choosingChar){
            if(!gameStart){
                if (xpos>Window.getX(Window.getWidth2()/4-25)&&xpos<Window.getX(Window.getWidth2()/4)+10
                        &&ypos>Window.getY(Window.getHeight2()/2-15)&&ypos<Window.getY(Window.getHeight2()/2)+23){
                    backingX=Window.getX(Window.getWidth2()/4-25);
                    backingY=Window.getY(Window.getHeight2()/2-12);
                    showBacking=true;
                }else if (xpos>Window.getX(Window.getWidth2()/2-25)&&xpos<Window.getX(Window.getWidth2()/2)+10
                        &&ypos>Window.getY(Window.getHeight2()/2-15)&&ypos<Window.getY(Window.getHeight2()/2)+23){
                    backingX=Window.getX(Window.getWidth2()/2-25);
                    backingY=Window.getY(Window.getHeight2()/2-12);
                    showBacking=true;
                }else if (xpos>Window.getX(Window.getWidth2()/4*3-25)&&xpos<Window.getX(Window.getWidth2()/4*3)+10
                        &&ypos>Window.getY(Window.getHeight2()/2-15)&&ypos<Window.getY(Window.getHeight2()/2)+23){
                    backingX=Window.getX(Window.getWidth2()/4*3-25);
                    backingY=Window.getY(Window.getHeight2()/2-12);
                    showBacking=true;
                }else                   
                    showBacking=false;
            } else {
                if (xpos>Window.getX(Window.getWidth2()/4)-150&&xpos<Window.getX(Window.getWidth2()/4)+150
                        &&ypos>Window.getY(Window.getHeight2()/4)-150&&ypos<Window.getY(Window.getHeight2()/4)+150){
                    backingX=Window.getX(Window.getWidth2()/4)-150;
                    backingY=Window.getY(Window.getHeight2()/4)-150;
                    showBacking=true;
                }else if (xpos>Window.getX(Window.getWidth2()/4*3)-150&&xpos<Window.getX(Window.getWidth2()/4*3)+150
                        &&ypos>Window.getY(Window.getHeight2()/4)-150&&ypos<Window.getY(Window.getHeight2()/4)+150){
                    backingX=Window.getX(Window.getWidth2()/4*3)-150;
                    backingY=Window.getY(Window.getHeight2()/4)-150;
                    showBacking=true;
                }else if (xpos>Window.getX(Window.getWidth2()/4)-150&&xpos<Window.getX(Window.getWidth2()/4)+150
                        &&ypos>Window.getX(Window.getWidth2()/4*3)-150&&ypos<Window.getX(Window.getWidth2()/4*3)+150){
                    backingX=Window.getX(Window.getWidth2()/4)-150;
                    backingY=Window.getX(Window.getWidth2()/4*3)-150;
                    showBacking=true;
                }
                else if(xpos>Window.getX(Window.getWidth2()/4*3)-150&&xpos<Window.getX(Window.getWidth2()/4*3)+150
                        &&ypos>Window.getX(Window.getWidth2()/4*3)-150&&ypos<Window.getX(Window.getWidth2()/4*3)+150){
                    backingX=Window.getX(Window.getWidth2()/4*3)-150;
                    backingY=Window.getX(Window.getWidth2()/4*3)-150;
                    showBacking=true;
                }else
                    showBacking=false;
            }
        }
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
<<<<<<< Updated upstream
        g.setColor(Color.white);
=======
        g.setColor(new Color(211,233,254));
>>>>>>> Stashed changes
        g.fillPolygon(x, y, 4);
// draw border
        g.setColor(Color.red);
        g.drawPolyline(x, y, 5);

        if (animateFirstTime) {
            gOld.drawImage(image, 0, 0, null);
            return;
        }  
<<<<<<< Updated upstream
        
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
        
=======
        if (showInstruct){
            Board.Draw(g);
            Board.drawInstruct(g);
        }
        else if (!gameStart){
            if (!choosingChar){
            g.drawImage(logoImage,Window.getX(0),Window.getY(0)-115,
                Window.getWidth2(),Window.getHeight2()*2-70,this);
            
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
            g.drawString("Start Game",Window.getX(Window.getWidth2()/5+2),Window.getY(Window.getHeight2()/4*3+25));
            g.drawString("Instructions",Window.getX(Window.getWidth2()/5*3),Window.getY(Window.getHeight2()/4*3+25));
            }
            else {
                if (showBacking)
                    Drawing.drawBacking(backingX, backingY, 35, 35);
                g.setColor(Color.black);
                g.setFont(new Font("Impact",Font.PLAIN,35));
                g.drawString("Number of Players?",Window.getX(Window.getWidth2()/7),Window.getY(Window.getHeight2()/4));
                g.drawString("2",Window.getX(Window.getWidth2()/4)-15,Window.getY(Window.getHeight2()/2+20));
                g.drawString("3",Window.getX(Window.getWidth2()/2)-15,Window.getY(Window.getHeight2()/2+20));
                g.drawString("4",Window.getX(Window.getWidth2()/4*3)-15,Window.getY(Window.getHeight2()/2+20));
            }                
        }
        else if (gameStart){  
            if (choosingChar){
                if (showBacking)
                    Drawing.drawBacking(backingX, backingY, 300, 300);
                g.setColor(Color.black);
                g.setFont(new Font("Impact",Font.PLAIN,35));
                g.drawString(Monster.getPlayersAL().get(0).getPlayerNum()+" Choosing",Window.getX(Window.getWidth2()/3),Window.getY(Window.getHeight2()/2)+25);
                Monster.drawCharOpt(g);
            }
            else
                Board.Draw(g);

        }
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
            }            
            boardImage = Toolkit.getDefaultToolkit().getImage("./board.jpg");  
            alienoidToken = Toolkit.getDefaultToolkit().getImage("./AL Player Token.png"); 
            cyberKittyToken = Toolkit.getDefaultToolkit().getImage("./CK Player Token.png");
            gigazaurToken = Toolkit.getDefaultToolkit().getImage("./GZ Player Token.png"); 
            mekaDragonToken = Toolkit.getDefaultToolkit().getImage("./MD Player Token.png");
=======
            }
            
            logoImage = Toolkit.getDefaultToolkit().getImage("./logo.png");  
            Board.setBoardImage();
            Monster.setMonsterImages();
            
>>>>>>> Stashed changes
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

