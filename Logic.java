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
            if (response.equals("6")) {
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
                RealEstate realEstate = constructRealEstateObj();
                person.addRealEstate(realEstate);
                System.out.println("You have added " + realEstate.getName().toUpperCase() + " to your portfolio.");

            } else if (response.equals("4")) {
                // View real estate portfolio logic here
                person.viewRealEstatePortfolio(scan);

            } else if (response.equals("5")){

                person.viewEntirePortfolio();

            }else {
                System.out.println("Invalid choice. Please try again.");
            }

            System.out.println();
        }
    }

    public RealEstate constructRealEstateObj () {
        System.out.print("Please enter the name of the real estate: ");
        String name = scan.nextLine();
        System.out.print("Please enter the cost of the real estate: ");
        double cost = scan.nextDouble();
        scan.nextLine(); // Consume the newline character
        System.out.print("Please enter the city of the real estate: ");
        String city = scan.nextLine();
        System.out.print("Please enter the state of the real estate: ");
        String state = scan.nextLine();
        System.out.print("Please enter the realtor of the real estate: ");
        String realtor = scan.nextLine();
        System.out.print("Please enter the square feet of the real estate: ");
        int squareFeet = scan.nextInt();
        scan.nextLine(); // Consume the newline character
        System.out.print("Please enter the number of bedrooms: ");
        String bedrooms = scan.nextLine();
        System.out.print("Please enter the number of bathrooms: ");
        String bathrooms = scan.nextLine();
        System.out.print("Please enter the year built: ");
        int yearBuilt = scan.nextInt();
        scan.nextLine(); // Consume the newline character
        System.out.print("Please enter the property type: ");
        String propertyType = scan.nextLine();
        return new RealEstate(cost, name, city, state, realtor, squareFeet, bedrooms, bathrooms, yearBuilt, propertyType);
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
