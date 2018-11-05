package kingoftokyo;

import java.awt.*;

public class Board {
    
    public static void Reset() {
    }    

    public static void AddTokenPixel(int xpixel,int ypixel) {
    }
    
    public static void Draw(Graphics2D g) {                         
    }
    
    public static boolean CheckWin()
    {                               
        if(Monster.victoryPoints == 20 /*|| only one monster remains*/) 
            return (true);
        
        return (false);
    }            
}
