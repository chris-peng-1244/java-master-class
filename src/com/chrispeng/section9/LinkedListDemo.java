package com.chrispeng.section9;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class LinkedListDemo
{
    public static void main(String[] args)
    {
        LinkedList<String> places = new LinkedList<>();

        addInOrder(places, "Sydney");
        addInOrder(places, "Melbourne");
        addInOrder(places, "Brisbane");
        addInOrder(places, "Perth");
        addInOrder(places, "Canberra");

        printList(places);
        visit(places);
    }

    private static void printList(LinkedList<String> linkedList)
    {
        Iterator<String> iter = linkedList.iterator();
        while (iter.hasNext()) {
            System.out.println("Now visiting " + iter.next());
        }
        System.out.println("==================");
    }

    private static boolean addInOrder(LinkedList<String> linkedList, String newCity)
    {
        ListIterator<String> stringListIterator = linkedList.listIterator();
        while (stringListIterator.hasNext()) {
            int comparison = stringListIterator.next().compareTo(newCity);
            if (comparison == 0) {
                System.out.println(newCity + " is already included as a destination");
                return false;
            } else if (comparison > 0) {
                stringListIterator.previous();
                stringListIterator.add(newCity);
                return true;
            }
        }

        stringListIterator.add(newCity);
        return true;
    }

    private static void visit(LinkedList<String> cities)
    {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;
        ListIterator<String> listIterator = cities.listIterator();

        if (cities.isEmpty()) {
            System.out.println("No cities in the iterator");
            return;
        } else {
            System.out.println("Now visiting " + listIterator.next());
            printMenu();
        }

        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
                case 0:
                    System.out.println("Holiday (Vacation) over");
                    quit = true;
                    break;
                case 1:
                    if (!goingForward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now visiting " + listIterator.next());
                    } else {
                        System.out.println("Reached the end of the list");
                        goingForward = false;
                    }
                    break;
                case 2:
                    if (goingForward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        goingForward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now visiting " + listIterator.previous());
                    } else {
                        System.out.println("We are at the start of the list");
                        goingForward = true;
                    }
                    break;
                case 3:
                    printMenu();
                    break;
                default:
                    printMenu();
            }
        }
    }

    private static void printMenu()
    {
        System.out.println("I am very lazy to type this down...");
    }
}
