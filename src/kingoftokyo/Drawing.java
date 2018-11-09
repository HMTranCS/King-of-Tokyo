package kingoftokyo;

import java.awt.*;

class Drawing {
    private static Graphics2D g;
    private static KingOfTokyo mainClassInst;

    public static void setDrawingInfo(Graphics2D _g,KingOfTokyo _mainClassInst) {
        g = _g;
        mainClassInst = _mainClassInst;
    }
////////////////////////////////////////////////////////////////////////////
    public static void drawImage(Image image,int xpos,int ypos,double rot,double xscale,
            double yscale) {
        int width = image.getWidth(mainClassInst);
        int height = image.getHeight(mainClassInst);
        g.translate(xpos,ypos);
        g.rotate(rot  * Math.PI/180.0);
        g.scale( xscale , yscale );

        g.drawImage(image,-width/2,-height/2,
        width,height,mainClassInst);

        g.scale( 1.0/xscale,1.0/yscale );
        g.rotate(-rot  * Math.PI/180.0);
        g.translate(-xpos,-ypos);
    } 
//////////////////////////////////////////////////////////////////////////// 
    public static void drawMonsterInfoBox(int xpos,int ypos) {
        g.setColor(Color.white); 
        g.fillRect(xpos, ypos, 200, 50);        
        
        g.setColor(Color.black); 
        g.drawRect(xpos, ypos, 200, 50);        
    } 
//////////////////////////////////////////////////////////////////////////// 
    public static void drawVictoryPoints(int xpos,int ypos,double rot,double xscale,double yscale) {  
        g.translate(xpos,ypos); 
        g.rotate(rot  * Math.PI/180.0);        
        g.scale(xscale,yscale);        
        
        g.setColor(Color.yellow);
        int xvals[]={0,5,20,10,20,0,-20,-10,-20,-5}; 
        int yvals[]={20,10,10,0,-20,-10,-20,0,10,10};
        g.fillPolygon(xvals,yvals,xvals.length); 
        
        g.setColor(Color.darkGray);
        g.drawPolygon(xvals,yvals,xvals.length);        
        
        g.scale(1.0/xscale,1.0/yscale); 
        g.rotate(-rot  * Math.PI/180.0);        
        g.translate(-xpos,-ypos);        
    } 
//////////////////////////////////////////////////////////////////////////// 
    public static void drawHealthPoints(int xpos,int ypos) {  
        g.translate(xpos,ypos);                 
        
        g.setColor(Color.red);
        int xvals[]={0,10,10,30,30,40,40,30,30,20,20,10,10,0,0}; 
        int yvals[]={20,20,30,30,20,20,0,0,-10,-10,-20,-20,-30,-30,-20};
        g.fillPolygon(xvals,yvals,xvals.length); 
        
        g.setColor(Color.darkGray);
        g.drawPolygon(xvals,yvals,xvals.length);        
                 
        g.translate(-xpos,-ypos);        
    } 
////////////////////////////////////////////////////////////////////////////     
}