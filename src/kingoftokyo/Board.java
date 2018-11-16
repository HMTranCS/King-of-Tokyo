package kingoftokyo;

import java.awt.*;

public class Board {
    private static Image boardImage;
    public static void setBoardImage() {
        boardImage = Toolkit.getDefaultToolkit().getImage("./board.jpg");
    }        
    public static void Draw(Graphics2D g) {  
        Drawing.drawMonsterInfoBox(Window.getX(0)*8, Window.getY(0)*3);
        Drawing.drawImage(boardImage,Window.getX(Window.getWidth2()/2),Window.getY(Window.getHeight2()/2),0.0, 0.2, 0.2); 
        if (KingOfTokyo.win){
            g.setColor(new Color(252,203,7));
            g.setFont(new Font("Impact",Font.PLAIN,45));
            g.drawString("You are the King of Tokyo!",65,325);
        }
    }    
    public static void drawInstruct(Graphics2D g) {  
        
    } 
}