public class Stock {
    private String symbol;
    private double price;

    public Stock(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
    }

    public String getSymbol() {
        return symbol;
    }

    public double getPrice() {
        return price;
    }

    public void updatePrice() {
        // Simulate price change: +/- 5%
        double change = (Math.random() - 0.5) * 0.1;
        price += price * change;
        price = Math.round(price * 100.0) / 100.0;
    }
}
