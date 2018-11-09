package kingoftokyo;

public class Dice {
    private static int numDice;    
    private static int gain1VictoryPoint;  
    private static int gain2VictoryPoints; 
    private static int gain3VictoryPoint; 
    private static int gainEnergy; 
    private static int smash; 
    private static int gainLifePoints; 

    public static void Reset() { 
        numDice = 6;
    } 
    
    Dice(int _gainEnergy, int _smash, int _gainLifePoints) { 
        gain1VictoryPoint = 1; 
        gain2VictoryPoints = 2; 
        gain3VictoryPoint = 3; 
        gainEnergy = _gainEnergy; 
        smash = _smash; 
        gainLifePoints = _gainLifePoints;
    } 
    
    public static int getNumDice() {
        return numDice;
    } 
    
    public static int getGain1VictoryPoint() {
        return gain1VictoryPoint;
    } 
    
    public static int getGain2VictoryPoints() {
        return gain2VictoryPoints;
    } 
    
    public static int getGain3VictoryPoint() {
        return gain3VictoryPoint;
    } 
    
    public static int getGainEnergy() {
        return gainEnergy;
    } 
 
    public static int getSmash() {
        return smash;
    } 
    
    public static int getGainLifePoints() {
        return gainLifePoints;
    }
}
