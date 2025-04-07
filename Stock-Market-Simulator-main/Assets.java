import java.util.ArrayList;
import java.util.Scanner;
public class Assets{
    
    private double cost;
    private String name;

    public Assets (double cost, String name) {
        this.cost = cost;
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public String getName () {
        return name;
    }

    public String toString () {
        String str = "";
        str += "=====================================";
        str += "\n" + name.toUpperCase() + " ASSET";
        str += "\nCost: $" + cost;
        return str;
    }

}
