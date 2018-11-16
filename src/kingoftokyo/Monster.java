package kingoftokyo;

public class Monster {
    private static Monster currPlayer; 
    private static int numPlayers = 2;
    private static Monster players[] = new Monster[numPlayers];
    private String name;    
    private int victoryPoints; 
    private int lifePoints;
        
    public static void Reset() {
       currPlayer = players[0];
    }
    
    Monster(String _name) {   
        name = _name; 
        victoryPoints = 0; 
        lifePoints = 10;
    }
    
    public static Monster getCurrentPlayer() {
        return currPlayer;
    } 
    
    public static int getNumPlayers() {
        return numPlayers;
    }
    
    public static void switchTurn() {
    }    
      
    public static Monster getPlayer1() {
        return players[0];
    }
    
    public static Monster getPlayer2() {
        return players[1];
    } 
    
    public String getName() {
        return(name);
    } 
    
    public int getVictoryPoints() {
        return victoryPoints;
    } 
    
    public int getLifePoints() {
        return lifePoints;
    }
}