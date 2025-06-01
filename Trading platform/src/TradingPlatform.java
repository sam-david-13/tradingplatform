import java.util.Map;
import java.util.Scanner;

public class TradingPlatform {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StockMarket market = new StockMarket();
        Portfolio portfolio = new Portfolio(10000); // initial cash

        int choice;
        do {
            market.updateMarket();
            System.out.println("\n=== Simulated Stock Trading ===");
            System.out.println("1. View Market Prices");
            System.out.println("2. Buy Stocks");
            System.out.println("3. Sell Stocks");
            System.out.println("4. View Portfolio");
            System.out.println("5. Exit");
            System.out.print("Choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    market.displayMarket();
                    break;
                case 2:
                    System.out.print("Enter stock symbol to buy: ");
                    String buySymbol = scanner.nextLine().toUpperCase();
                    System.out.print("Enter quantity: ");
                    int buyQty = scanner.nextInt();
                    Stock buyStock = market.getStocks().get(buySymbol);
                    if (buyStock != null && portfolio.buy(buySymbol, buyQty, buyStock.getPrice())) {
                        System.out.println("Buy successful.");
                    } else {
                        System.out.println("Buy failed. Check cash or symbol.");
                    }
                    break;
                case 3:
                    System.out.print("Enter stock symbol to sell: ");
                    String sellSymbol = scanner.nextLine().toUpperCase();
                    System.out.print("Enter quantity: ");
                    int sellQty = scanner.nextInt();
                    Stock sellStock = market.getStocks().get(sellSymbol);
                    if (sellStock != null && portfolio.sell(sellSymbol, sellQty, sellStock.getPrice())) {
                        System.out.println("Sell successful.");
                    } else {
                        System.out.println("Sell failed. Check holdings or symbol.");
                    }
                    break;
                case 4:
                    portfolio.displayPortfolio(market.getStocks());
                    break;
                case 5:
                    System.out.println("Exiting. Happy Trading!");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
