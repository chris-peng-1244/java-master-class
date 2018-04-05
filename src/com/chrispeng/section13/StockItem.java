package com.chrispeng.section13;

public class StockItem implements Comparable<StockItem>
{
    private final String name;
    private double price;
    private int quantityInStock = 0;
    private int reserved = 0;

    public StockItem(String name, double price)
    {
        this.name = name;
        this.price = price;
    }

    public StockItem(String name, double price, int quantityInStock)
    {
        this.name = name;
        this.price = price;
        this.quantityInStock = quantityInStock;
    }

    public String getName()
    {
        return name;
    }

    public double getPrice()
    {
        return price;
    }

    public int getAvailableQuantity()
    {
        return reserved < quantityInStock ? quantityInStock - reserved : 0;
    }

    public void setPrice(double price)
    {
        if (price > 0.0) {
            this.price = price;
        }
    }

    public boolean reserve(int quantity)
    {
        if (quantity > 0 && (quantity + reserved) <= quantityInStock) {
            reserved += quantity;
            return true;
        }
        return false;
    }

    public boolean unreserve(int quantity)
    {
        if (quantity <= reserved) {
            reserved -= quantity;
            return true;
        }
        return false;
    }

    public void adjustStock(int quantity) {
        int newQuantity = this.quantityInStock + quantity;
        if (newQuantity >= 0) {
            this.quantityInStock = newQuantity;
        }
    }

    public int finaliseStock(int quantity) {
        if (quantity <= reserved) {
            quantityInStock -= quantity;
            reserved -= quantity;
            return quantity;
        }
        return 0;
    }

    @Override
    public boolean equals(Object obj)
    {
        System.out.println("Entering StockItem.equals");
        if (obj == this) {
            return true;
        }

        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }

        String objName = ((StockItem) obj).getName();
        return this.name.equals(objName);
    }

    @Override
    public int hashCode()
    {
        return this.name.hashCode() + 31;
    }

    @Override
    public int compareTo(StockItem o)
    {
        System.out.println("Entering StockItem.compare");
        if (this == o) {
            return 0;
        }

        if (o != null) {
            return this.name.compareTo(o.getName());
        }
        throw new NullPointerException();
    }

    @Override
    public String toString()
    {
        return this.name + ": " + this.price + ": Reserved: " + this.reserved;
    }
}
