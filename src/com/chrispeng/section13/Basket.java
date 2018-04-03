package com.chrispeng.section13;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Basket
{
    private final String name;
    private final Map<StockItem, Integer> list;

    public Basket(String name)
    {
        this.name = name;
        this.list = new HashMap<>();
    }

    public int addToBasket(StockItem item, int quantity)
    {
        if (item != null && (quantity > 0) && (item.getAvailableQuantity() >= quantity)) {
            item.reserve(quantity);
            int inBasket = list.getOrDefault(item,  0);
            list.put(item, inBasket + quantity);
            return inBasket;
        }
        return 0;
    }

    public int removeFromBasket(StockItem item)
    {
        if (!list.containsKey(item)) {
            return 0;
        }
        return removeFromBasket(item, list.get(item));
    }

    public int removeFromBasket(StockItem item, int quantity)
    {
        if (item == null || !list.containsKey(item)) {
            return 0;
        }
        if (quantity <= 0 || list.get(item) < quantity) {
            return 0;
        }
        if (list.get(item) == quantity) {
            list.remove(item);
        } else {
            list.put(item, list.get(item) - quantity);
        }
        item.unreserve(quantity);
        return quantity;
    }

    public void clear()
    {
        list.clear();
    }

    public boolean checkOut()
    {
        if (list.size() == 0) {
            return false;
        }

        for (Map.Entry<StockItem, Integer> entry : list.entrySet()) {
            StockItem item = entry.getKey();
            item.finaliseStock(entry.getValue());
        }
        list.clear();
        return true;
    }

    public Map<StockItem, Integer> Items() {
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString()
    {
        String s = "\nShopping basket " + name + " contains " + list.size() + ((list.size() == 1) ? " item" : " items") + "\n";
        double totalCost = 0.0;
        for (Map.Entry<StockItem, Integer> item: list.entrySet()) {
            s = s + item.getKey() + ". $" + item.getValue() + " purchased\n";
            totalCost += item.getKey().getPrice() * item.getValue();
        }
        return s + "Total cost " + totalCost;
    }
}
