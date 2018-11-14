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
    public static void drawMonsterInfoBox(int xpos,int ypos,int VictoryPointsXPos,int VictoryPointsYPos,double VictoryPointsRot,double VictoryPointsXScale,double VictoryPointsYScale,int HealthPointsXPos,int HealthPointsYPos,double HealthPointsRot,double HealthPointsXScale,double HealthPointsYScale,int EnergyPointsXPos,int EnergyPointsYPos,double EnergyPointsXScale,double EnergyPointsYScale) {
        g.setColor(Color.white); 
        g.fillRect(xpos, ypos, 184, 50);        
        
        g.setColor(Color.black); 
        g.drawRect(xpos, ypos, 184, 50);   
        
        g.translate(VictoryPointsXPos,VictoryPointsYPos); 
        g.rotate(VictoryPointsRot  * Math.PI/180.0);        
        g.scale(VictoryPointsXScale,VictoryPointsYScale);        
        
        g.setColor(Color.yellow);
        int xvals[]={0,5,20,10,20,0,-20,-10,-20,-5}; 
        int yvals[]={20,10,10,0,-20,-10,-20,0,10,10};
        g.fillPolygon(xvals,yvals,xvals.length); 
        
        g.setColor(Color.darkGray);
        g.drawPolygon(xvals,yvals,xvals.length);        
        
        g.scale(1.0/VictoryPointsXScale,1.0/VictoryPointsYScale); 
        g.rotate(-VictoryPointsRot  * Math.PI/180.0);        
        g.translate(-VictoryPointsXPos,-VictoryPointsYPos); 
        
        g.setColor(Color.black); 
        g.setFont(new Font("Arial",Font.PLAIN,40));
        g.drawString("0",40,460); 
        
        g.setColor(Color.black); 
        g.setFont(new Font("Arial",Font.PLAIN,40));
        g.drawString("0",658,460); 

        g.setColor(Color.black); 
        g.setFont(new Font("Arial",Font.PLAIN,40));
        g.drawString("0",348,180); 
        
        g.setColor(Color.black); 
        g.setFont(new Font("Arial",Font.PLAIN,40));
        g.drawString("0",348,740);
        
        g.translate(HealthPointsXPos,HealthPointsYPos);
        g.rotate(HealthPointsRot  * Math.PI/180.0);
        g.scale(HealthPointsXScale,HealthPointsYScale);
       
        g.setColor(Color.red);
        int HealthPointsXVals[]={0,10,10,30,30,40,40,30,30,20,20,10,10,0,0,-10,-10,-20,-20,-30,-30,-20,-20,0}; 
        int HealthPointsYVals[]={20,20,30,30,20,20,0,0,-10,-10,-20,-20,-30,-30,-20,-20,-10,-10,0,0,20,20,30,30};  
        g.fillPolygon(HealthPointsXVals,HealthPointsYVals,HealthPointsXVals.length);                  
        
        g.setColor(Color.darkGray);
        g.drawPolygon(HealthPointsXVals,HealthPointsYVals,HealthPointsXVals.length);        
                 
        g.scale(1.0/HealthPointsXScale,1.0/HealthPointsYScale);
        g.rotate(-HealthPointsRot  * Math.PI/180.0);
        g.translate(-HealthPointsXPos,-HealthPointsYPos);
        
        g.setColor(Color.black); 
        g.setFont(new Font("Arial",Font.PLAIN,45));
        g.drawString("10",90,460); 
        
        g.setColor(Color.black); 
        g.setFont(new Font("Arial",Font.PLAIN,45));
        g.drawString("10",708,460); 
     
        g.setColor(Color.black); 
        g.setFont(new Font("Arial",Font.PLAIN,45));
        g.drawString("10",400,180); 
  
        g.setColor(Color.black); 
        g.setFont(new Font("Arial",Font.PLAIN,45));
        g.drawString("10",400,740);
        
        g.translate(EnergyPointsXPos,EnergyPointsYPos);
        g.scale( EnergyPointsXScale , EnergyPointsYScale ); 
        
        g.setColor(Color.green); 
        int EnergyPointsXVals[]={0,-10,5,5,15,0}; 
        int EnergyPointsYVals[]={0,0,-20,-5,-5,15};
        g.fillPolygon(EnergyPointsXVals,EnergyPointsYVals,EnergyPointsXVals.length); 
        
        g.setColor(Color.darkGray); 
        g.drawPolygon(EnergyPointsXVals,EnergyPointsYVals,EnergyPointsXVals.length);
        
        g.scale( 1.0/EnergyPointsXScale,1.0/EnergyPointsYScale );
        g.translate(-EnergyPointsXPos,-EnergyPointsYPos); 
        
        g.setColor(Color.black); 
        g.setFont(new Font("Arial",Font.PLAIN,45));
        g.drawString("0",165,460); 
        
        g.setColor(Color.black); 
        g.setFont(new Font("Arial",Font.PLAIN,45));
        g.drawString("0",783,460); 
   
        g.setColor(Color.black); 
        g.setFont(new Font("Arial",Font.PLAIN,45));
        g.drawString("0",470,180); 
       
        g.setColor(Color.black); 
        g.setFont(new Font("Arial",Font.PLAIN,45));
        g.drawString("0",475,740);
    } 
} 
