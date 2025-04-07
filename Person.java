import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class Person {
  
    private Assets assetsObject;
    private ArrayList<ArrayList<Assets>> assets;
    private ArrayList<Stock> stocks;
    private ArrayList<RealEstate> realEstatePortfolio;
    private String name;

    public Person (String name) {
        this.name = name;
        assets = new ArrayList<ArrayList<Assets>>();
        stocks = new ArrayList<Stock>();
        realEstatePortfolio = new ArrayList<RealEstate>();
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

    public void viewRealEstatePortfolio (Scanner scan) {
        if (realEstatePortfolio.isEmpty()) {
            System.out.println("You have no real estate in your portfolio.");
            return;
        }

        System.out.println("=====================================");
        System.out.println("Your Real Estate Portfolio: ");
        for (int i = 0; i < realEstatePortfolio.size(); i++) {
            System.out.println("(" + i + 1 + ") " + realEstatePortfolio.get(i).getName().toUpperCase() + " REAL ESTATE");
        }
        System.out.println("=====================================");
        System.out.print("Please enter the number of the real estate you would like to view: ");
        int choice = scan.nextInt() - 1;
        scan.nextLine();
        if (choice < 0 || choice >= realEstatePortfolio.size()) {
            System.out.println("Invalid choice. Please try again.");
            return;
        }
        RealEstate realEstate = realEstatePortfolio.get(choice);
        System.out.println(realEstate);
    }

    public void addStock (Stock stock) {
        stocks.add(stock);
    }

    public void addRealEstate (RealEstate realEstate) {
        realEstatePortfolio.add(realEstate);
    }

}
