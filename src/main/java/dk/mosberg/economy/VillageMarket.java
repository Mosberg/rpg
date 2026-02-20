package dk.mosberg.economy;

import java.util.HashMap;
import java.util.Map;

/**
 * Dynamic market system for village trades.
 */
public class VillageMarket {
    private final Map<String, Integer> prices = new HashMap<>();
    private final Map<String, Integer> stock = new HashMap<>();

    public void setPrice(String item, int price) {
        prices.put(item, price);
    }

    public int getPrice(String item) {
        return prices.getOrDefault(item, 1);
    }

    public void setStock(String item, int amount) {
        stock.put(item, amount);
    }

    public int getStock(String item) {
        return stock.getOrDefault(item, 0);
    }

    public void buy(String item, int amount) {
        stock.put(item, Math.max(0, getStock(item) - amount));
    }

    public void sell(String item, int amount) {
        stock.put(item, getStock(item) + amount);
    }

    public Map<String, Integer> getAllPrices() {
        return prices;
    }

    public Map<String, Integer> getAllStock() {
        return stock;
    }
}
