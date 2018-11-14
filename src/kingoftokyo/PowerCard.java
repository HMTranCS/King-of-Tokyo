package kingoftokyo;

public class PowerCard { 
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
    }
}