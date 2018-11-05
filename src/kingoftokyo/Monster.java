package kingoftokyo;

public class Monster {
    private static Monster currPlayer;
    private static Monster players[] = new Monster[2];
//    private String name;    
    public static int victoryPoints; 
//    private int lifePoints;    
        
    public static void Reset() {
       currPlayer = players[0];
    }
    
    Monster() { 
        victoryPoints = 0;        
    }
    
    public static Monster getCurrentPlayer() {
        return currPlayer;
    }
    
    public static void switchTurn() {
    }    
      
    public static Monster getPlayer1() {
        return players[0];
    }
    
    public static Monster getPlayer2() {
        return players[1];
    } 
    
    public int getvictoryPoints() {
        return victoryPoints;
    }
}