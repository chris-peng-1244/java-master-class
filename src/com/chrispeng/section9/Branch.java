package com.chrispeng.section9;

import java.util.ArrayList;

public class Branch
{
    private ArrayList<Customer> customers = new ArrayList<>();

    public boolean addCustomer(Customer customer, double transaction)
    {
        int findCustomer = findCustomer(customer);
        if (-1 == findCustomer) {
            customer.addTransaction(transaction);
            customers.add(customer);
            return true;
        }
        System.out.println("Customer " + customer.getName()+" is already in the bank");
        return false;
    }

    public boolean addTransaction(Customer customer, double transaction)
    {
        int findCustomer = findCustomer(customer);
        if (-1 == findCustomer) {
            System.out.println("Customer "+customer.getName()+" not found");
            return false;
        }
        Customer customer1 = customers.get(findCustomer);
        customer1.addTransaction(transaction);
        return true;
    }

    private int findCustomer(Customer customer)
    {
        return customers.indexOf(customer);
    }

    public ArrayList<Customer> getCustomers()
    {
        return customers;
    }
}
