import java.util.HashMap;
import java.util.Map;

public class StockMarket {
    private Map<String, Stock> stocks = new HashMap<>();

    public StockMarket() {
        stocks.put("AAPL", new Stock("AAPL", 150));
        stocks.put("GOOG", new Stock("GOOG", 2800));
        stocks.put("TSLA", new Stock("TSLA", 700));
        stocks.put("MSFT", new Stock("MSFT", 300));
    }

    public void updateMarket() {
        for (Stock stock : stocks.values()) {
            stock.updatePrice();
        }
    }

    public Map<String, Stock> getStocks() {
        return stocks;
    }

    public void displayMarket() {
        System.out.println("\n--- Market Prices ---");
        for (Stock stock : stocks.values()) {
            System.out.printf("%s: $%.2f\n", stock.getSymbol(), stock.getPrice());
        }
    }
}
