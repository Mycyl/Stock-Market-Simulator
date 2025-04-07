import java.util.ArrayList;
import java.util.Scanner;

public class Person {
  
    private Assets assetsObject;
    private ArrayList<ArrayList<Assets>> assets;
    private ArrayList<Stock> stocks;
    private ArrayList<RealEstate> realEstatePortfolio = new ArrayList<RealEstate>();
    private String name;

    public Person (String name) {
        this.name = name;
        assets = new ArrayList<ArrayList<Assets>>();
        stocks = new ArrayList<Stock>();

    }

    public String getName () {
        return name;
    }

    public void viewStockPortfolio (Scanner scan) {
        
        if (stocks.isEmpty()) {
            System.out.println("You have no stocks in your portfolio.");
            return;
        }

        System.out.println("=====================================");
        System.out.println("Your Stock Portfolio: ");
        for (int i = 0; i < stocks.size(); i++) {
            System.out.println("(" + i + 1 + ") " + stocks.get(i).getName().toUpperCase() + " STOCK");
        }
        System.out.println("=====================================");
        System.out.print("Please enter the number of the stock you would like to view: ");
        int choice = scan.nextInt() - 1;
        scan.nextLine();
        if (choice < 0 || choice >= stocks.size()) {
            System.out.println("Invalid choice. Please try again.");
            return;
        }
        Stock stock = stocks.get(choice);
        System.out.println(stock);
    }

    public void viewEntirePortfolio () {
        for (ArrayList<Assets> assetList : assets) {
            for (Assets asset : assetList) {
                System.out.println(asset.getName() + ": $" + asset.getCost());
            }
        }
    }

    public void addStock (Stock stock) {
        stocks.add(stock);
    }

}
