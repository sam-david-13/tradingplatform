import java.util.HashMap;
import java.util.Map;

public class Portfolio {
    private double cash;
    private Map<String, Integer> holdings = new HashMap<>();
    private Map<String, Double> buyPrices = new HashMap<>();

    public Portfolio(double initialCash) {
        this.cash = initialCash;
    }

    public boolean buy(String symbol, int quantity, double price) {
        double cost = quantity * price;
        if (cost > cash) return false;

        holdings.put(symbol, holdings.getOrDefault(symbol, 0) + quantity);
        buyPrices.put(symbol, price); // store average buy price (simplified)
        cash -= cost;
        return true;
    }

    public boolean sell(String symbol, int quantity, double price) {
        int owned = holdings.getOrDefault(symbol, 0);
        if (owned < quantity) return false;

        holdings.put(symbol, owned - quantity);
        cash += quantity * price;

        if (holdings.get(symbol) == 0) {
            holdings.remove(symbol);
            buyPrices.remove(symbol);
        }
        return true;
    }

    public void displayPortfolio(Map<String, Stock> market) {
        System.out.println("\n--- Portfolio ---");
        System.out.printf("Cash: $%.2f\n", cash);

        double totalValue = cash;
        for (String symbol : holdings.keySet()) {
            int qty = holdings.get(symbol);
            double marketPrice = market.get(symbol).getPrice();
            double buyPrice = buyPrices.get(symbol);
            double value = qty * marketPrice;
            double profit = (marketPrice - buyPrice) * qty;

            System.out.printf("%s: %d shares | Buy: $%.2f | Market: $%.2f | Value: $%.2f | P/L: $%.2f\n",
                    symbol, qty, buyPrice, marketPrice, value, profit);

            totalValue += value;
        }

        System.out.printf("Total Portfolio Value: $%.2f\n", totalValue);
    }
}
