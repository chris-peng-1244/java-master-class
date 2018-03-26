package com.chrispeng.section11;

import java.util.ArrayList;

public class Generics
{
    public static void main(String[] args)
    {
        ArrayList<Integer> items = new ArrayList();
        items.add(1);
        items.add(2);
        items.add(3);
        items.add(5);

        print(items);
    }

    private static void print(ArrayList<Integer> items)
    {
        for (int j : items) {
            System.out.println(j * 2);
        }
    }
}
