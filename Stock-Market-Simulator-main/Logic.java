import java.util.Scanner;
import java.util.ArrayList;

public class Logic {

    private Scanner scan;

    public Logic () {
        scan = new Scanner(System.in);
    }

    public void start () {

        System.out.println("Welcome to your asset tracker!");
        System.out.print("Please enter your name: ");
        Person person = new Person(scan.nextLine());
        System.out.println("Hello " + person.getName() + "!");
        String response = "";
        while (!response.equals("5")) {

            printMenu();
            response = scan.nextLine();
            if (response.equals("5")) {
                break;
            }

            if (response.equals("2")) {

                person.viewStockPortfolio(scan);

            } else if (response.equals("1")) {

                Stock stock = makeStock();
                person.addStock(stock);
                System.out.println("You have added " + stock.getName().toUpperCase() + " to your portfolio.");
                
            } else if (response.equals("3")) {
                // Add real estate logic here
            } else if (response.equals("4")) {
                // View real estate portfolio logic here
            } else {
                System.out.println("Invalid choice. Please try again.");
            }

            System.out.println();
        }
    }

    public void printMenu () {
        System.out.println("=====================================");
        System.out.println("Please enter your choice:");
        System.out.println("1. Add a stock to your portfolio");
        System.out.println("2. View your stock portfolio");
        System.out.println("3. Add real estate to your portfolio");
        System.out.println("4. View your real estate portfolio");
        System.out.println("5. View entire portfolio");
        System.out.println("6. Exit");
        System.out.println("=====================================");
        System.out.print("Please enter your choice: ");
    }

    public Stock makeStock () {
        System.out.print("Please enter the name of the stock: ");
        String name = scan.nextLine();
        double[] stockData = Parse.parseResponseData(name);
        Stock stock = new Stock(name, stockData[0], stockData[1], stockData[2], stockData[3], stockData[4], stockData[5], stockData[6]);
        return stock;
    }
}
