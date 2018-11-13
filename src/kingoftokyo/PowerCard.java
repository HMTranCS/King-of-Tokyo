package kingoftokyo;

public class PowerCard { 
<<<<<<< HEAD
    private String name; 
//    private static int cost; 
//    private static String effect; 
    
    PowerCard(String _name) {
=======
    private static String name; 
    private static int cost; 
    private static String effect; 
    
    PowerCard(String _name, int _cost, String _effect) { 
        name = _name; 
        cost = _cost; 
        effect = _effect;
    } 
    
    public static String getName() {
        return name;
    } 
    
    public static int getCost() {
        return cost;
    } 
    
    public static String getEffect() {
        return effect;
>>>>>>> 01a297822665a8a8488b9880f8d1a0fd7a6592ab
    }
}