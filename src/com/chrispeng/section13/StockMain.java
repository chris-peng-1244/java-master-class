package com.chrispeng.section13;

import com.chrispeng.section11.BaseballPlayer;

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

        Basket basket = new Basket("Tim");
        sellItem(basket, "car", 1);
        System.out.println(basket);

        sellItem(basket, "car", 1);
        System.out.println(basket);

        if (sellItem(basket, "car", 1) != 1) {
            System.out.println("There are no more cars in stock");
        }
//        System.out.println(basket);

        sellItem(basket, "farri", 1);
        System.out.println(basket);

        sellItem(basket, "chair", 4);
        sellItem(basket, "cup", 1);
        sellItem(basket, "towel", 1);
        System.out.println(basket);

        stockList.Items().get("car").adjustStock(2000);
        System.out.println(stockList);

        for (Map.Entry<String, Double> price: stockList.PriceList().entrySet()) {
            System.out.println(price.getKey() + " costs " + price.getValue());
        }
    }

    public static int sellItem(Basket basket, String item, int quantity)
    {
        StockItem stockItem = stockList.get(item);
        if (stockItem == null) {
            System.out.println("Wd don't sell " + item);
            return 0;
        }
        if (stockList.sellStock(item, quantity) != 0) {
            basket.addToBasket(stockItem, quantity);
            return quantity;
        }
        return 0;
    }
}
