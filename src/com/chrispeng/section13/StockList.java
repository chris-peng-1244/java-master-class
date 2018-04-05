package com.chrispeng.section13;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class StockList
{
    private final Map<String, StockItem> list;

    public StockList()
    {
        this.list = new LinkedHashMap<>();
    }

    public int addStock(StockItem item)
    {
        if (item != null) {
            // Check if already have quantities of this item
            StockItem inStock = list.getOrDefault(item.getName(), item);
            // If there are already stocks on this item, adjust the quqntity
            if (inStock != item) {
                item.adjustStock(inStock.getAvailableQuantity());
            }
            list.put(item.getName(), item);
            return item.getAvailableQuantity();
        }
        return 0;
    }

    public int sellStock(String item, int quantity) {
        StockItem inStock = list.get(item);
        if (inStock != null && quantity > 0) {
            return inStock.finaliseStock(quantity);
        }
        return 0;
    }

    public boolean reserveStock(String item, int quantity) {
        StockItem inStock = list.get(item);
        if (null == inStock || quantity <= 0) {
            return false;
        }
        return inStock.reserve(quantity);
    }

    public boolean unReserveStock(String item, int quantity) {
        StockItem inStock = list.get(item);
        if (null == inStock || quantity <= 0) {
            return false;
        }
        return inStock.unreserve(quantity);
    }

    public StockItem get(String key)
    {
        return list.get(key);
    }

    public Map<String, Double> PriceList()
    {
        Map<String, Double> prices = new LinkedHashMap<>();
        for (Map.Entry<String, StockItem> item: list.entrySet()) {
            prices.put(item.getKey(), item.getValue().getPrice());
        }
        return prices;
    }

    public Map<String, StockItem> Items() {
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString()
    {
        String s = "\nStock List\n";
        double totalCost = 0.0;
        for (Map.Entry<String, StockItem> item: list.entrySet()) {
            StockItem stockItem = item.getValue();
            double itemValue = stockItem.getPrice() * stockItem.getAvailableQuantity();
            s = s + stockItem + ". There are " + stockItem.getAvailableQuantity() + " in stock. Value of items: ";
            s = s + String.format("%.2f", itemValue) + "\n";
            totalCost += itemValue;
        }
        return s + "Total stock value " + totalCost;
    }
}
