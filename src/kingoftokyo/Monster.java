package kingoftokyo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

public class Monster {
<<<<<<< Updated upstream
    private static Monster currPlayer; 
    private static int numPlayers = 2;
    private static Monster players[] = new Monster[numPlayers];
    private String name;    
    private int victoryPoints; 
    private int lifePoints;
=======
    private static Monster currPlayer;
    private static ArrayList<Monster> players = new ArrayList<Monster>();
    private static Monster monsters[] = new Monster[4];
    private String name;    
    private int victoryPoints; 
    private int lifePoints;    
    private String playerNum;
    private Monster playerChar; 
    
    private static Image ckImage; 
    private static Image gzImage; 
    private static Image mdImage; 
    private static Image anImage; 
    private static Image ckToken; 
    private static Image gzToken; 
    private static Image mdToken; 
    private static Image anToken; 
>>>>>>> Stashed changes
        
    public static void Reset() {
       currPlayer = players.get(0);
       monsters[0] = new Monster("CyberKitty", ckImage, ckToken);
       monsters[1] = new Monster("Gigazaur", gzImage, gzToken);
       monsters[2] = new Monster("MekaDragon", mdImage, mdToken);
       monsters[3] = new Monster("Alienoid", anImage, anToken);
    }
    public static void createPlayers(int numPlayers){
        for(int i=0;i<numPlayers;i++){
            Monster ptr = new Monster("Player "+ (i+1));
            players.add(ptr);
        }
        
    }
    public static void setMonsterImages(){
        ckImage = Toolkit.getDefaultToolkit().getImage("./CK Full.png"); 
        gzImage = Toolkit.getDefaultToolkit().getImage("./GZ Full.png"); 
        mdImage = Toolkit.getDefaultToolkit().getImage("./MD Full.png"); 
        anImage = Toolkit.getDefaultToolkit().getImage("./AL Full.png"); 
        ckToken = Toolkit.getDefaultToolkit().getImage("./CK Token.png"); 
        gzToken = Toolkit.getDefaultToolkit().getImage("./GZ Token.png"); 
        mdToken = Toolkit.getDefaultToolkit().getImage("./MD Token.png"); 
        anToken = Toolkit.getDefaultToolkit().getImage("./AL Token.png"); 
    }
    public static void drawCharOpt(Graphics2D g){
        
        Drawing.drawImage(ckImage,Window.getX(Window.getWidth2()/4),Window.getY(Window.getHeight2()/4),0.0, 1.0, 1.0);
        Drawing.drawImage(gzImage,Window.getX(Window.getWidth2()/4*3),Window.getY(Window.getHeight2()/4),0.0, 1.0, 1.0); 
        Drawing.drawImage(mdImage,Window.getX(Window.getWidth2()/4),Window.getY(Window.getHeight2()/4*3),0.0, 1.0, 1.0); 
        Drawing.drawImage(anImage,Window.getX(Window.getWidth2()/4*3),Window.getY(Window.getHeight2()/4*3),0.0, 1.0, 1.0);
        
    }
    public static Monster getCurrentPlayer() {
        return currPlayer;
    } 
    
    public static int getNumPlayers() {
        return numPlayers;
    }
    public static ArrayList<Monster> getPlayersAL() {
        return players;
    }
    public static Monster[] getMonsters() {
        return monsters;
    }
    public static boolean CheckWin()
    {   
        for (Monster ptr:Monster.getPlayersAL()){
            if (ptr.getVictoryPoints() == 20){
                return(true);
            }
        }
        return (false);
    }     
    public static void switchTurn() {
        if (currPlayer == players.get(0))
            currPlayer = players.get(1);
        else if (currPlayer == players.get(1))
            currPlayer = players.get(2);
        else if (currPlayer == players.get(2))
            currPlayer = players.get(3);
        else if (currPlayer == players.get(3))
            currPlayer = players.get(0);
    }   
    Monster(String _name, Image _character, Image _token) {   
        name = _name; 
    }
    Monster(String _name){
        playerNum = _name;
        playerChar = null;
        victoryPoints = 0; 
        lifePoints = 10;
    }
    public String getName() {
        return(name);
    } 
    public String getPlayerNum(){
        return playerNum;
    }
    public int getVictoryPoints() {
        return victoryPoints;
    } 
    public int getLifePoints() {
        return lifePoints;
    }
}