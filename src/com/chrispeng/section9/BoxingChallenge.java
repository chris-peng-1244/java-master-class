package com.chrispeng.section9;

public class BoxingChallenge
{
    public static void main(String[] args)
    {
        Bank bank = new Bank();
        Branch branch1 = bank.createBranch();
        Customer john = new Customer("John");
        Customer mike = new Customer("Mike");
        bank.addCustomer(branch1, john, 100);
        bank.addCustomer(branch1, mike, 2000);
        bank.addTransaction(branch1, mike, 500);
        bank.addTransaction(branch1, john, -10);
        bank.showCustomersOfBranch(branch1, true);
    }
}
