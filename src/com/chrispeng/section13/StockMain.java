package com.chrispeng.section13;

import java.util.Map;

public class StockMain
{
    private static StockList stockList = new StockList();
    
    public static void main(String[] args)
    {
        StockItem temp = new StockItem("bread",  0.86, 100);
        stockList.addStock(temp);

        temp = new StockItem("cake", 1.10, 7);
        stockList.addStock(temp);

        temp = new StockItem("car", 12.10, 2);
        stockList.addStock(temp);

        temp = new StockItem("cup", 3.30, 20);
        stockList.addStock(temp);

        temp = new StockItem("chair", 10.10, 200);
        stockList.addStock(temp);

        temp = new StockItem("door", 110.0, 5);
        stockList.addStock(temp);

        temp = new StockItem("vase", 47.0, 50);
        stockList.addStock(temp);

        temp = new StockItem("towel", 9.90, 11);
        stockList.addStock(temp);
        temp = new StockItem("towel", 0.99, 11);
        stockList.addStock(temp);

        System.out.println(stockList);


        for (String s: stockList.Items().keySet()) {
            System.out.println(s);
        }

        Basket basket = new Basket("Chris");
        addToBasket(basket, "cup", 1);
        addToBasket(basket, "juice", 100);
        addToBasket(basket, "cup", 1);
        System.out.println(basket);

        removeFromBasket(basket, "car", 1);
        removeFromBasket(basket, "cup", 1);
        removeFromBasket(basket, "car", 1);
        System.out.println(basket);
    }

    public static int addToBasket(Basket basket, String item, int quantity)
    {
        StockItem stockItem = stockList.get(item);
        if (stockItem == null) {
            System.out.println("Wd don't sell " + item);
            return 0;
        }
        return basket.addToBasket(stockItem, quantity);
    }

    public static int removeFromBasket(Basket basket, String item, int quantity)
    {
        StockItem stockItem = stockList.get(item);
        if (stockItem == null) {
            System.out.println("You don't have " + item + " in your basket");
            return 0;
        }

        return basket.removeFromBasket(stockItem, quantity);
    }
}
