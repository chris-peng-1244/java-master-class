package com.chrispeng.section9;

import java.util.ArrayList;

public class Customer
{
    private ArrayList<Double> transactions = new ArrayList<>();
    private String name;

    public Customer(String name)
    {
        this.name = name;
    }

    public Customer(String name, double transaction)
    {
        this.name = name;
        transactions.add(transaction);
    }

    public String getName()
    {
        return name;
    }

    public void addTransaction(double transaction)
    {
        transactions.add(transaction);
    }

    public ArrayList<Double> getTransactions()
    {
        return transactions;
    }
}
