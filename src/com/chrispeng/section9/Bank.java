package com.chrispeng.section9;

import java.util.ArrayList;

public class Bank
{
    private ArrayList<Branch> branches = new ArrayList<>();

    public Branch createBranch()
    {
        Branch branch = new Branch();
        branches.add(branch);
        return branch;
    }

    public boolean addCustomer(Branch branch, Customer customer, double transaction)
    {
        return branch.addCustomer(customer, transaction);
    }

    public boolean addTransaction(Branch branch, Customer customer, double transaction)
    {
        return branch.addTransaction(customer, transaction);
    }

    public void showCustomersOfBranch(Branch branch, boolean isTxShown)
    {
        ArrayList<Customer> customers = branch.getCustomers();
        for (Customer customer: customers) {
            System.out.println("Customer name is " + customer.getName());
            if (isTxShown) {
                ArrayList<Double> transactions = customer.getTransactions();
                for (double transaction : transactions) {
                    System.out.println("Transaction amount: " + transaction);
                }
            }
        }
    }
}
