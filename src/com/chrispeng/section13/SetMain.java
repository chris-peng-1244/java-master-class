package com.chrispeng.section13;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetMain
{
    public static void main(String[] args)
    {
        Set<String> nature = new HashSet<>();
        String[] natureWords = {"all", "nature", "is", "but", "art", "unknown", "to", "three"};
        nature.addAll(Arrays.asList(natureWords));

        Set<String> divine = new HashSet<>();
        String[] divineWords = {"to", "err", "is", "human", "to", "forgive", "divine"};
        divine.addAll(Arrays.asList(divineWords));

        System.out.println("nature - divine:");
        Set<String> diff1 = new HashSet<>(nature);
        diff1.removeAll(divine);
        printSet(diff1);

        System.out.println("divine - nature:");
        Set<String> diff2 = new HashSet<>(divine);
        diff2.removeAll(nature);
        printSet(diff2);

        Set<String> unionTest = new HashSet<>(nature);
        unionTest.addAll(divine);
        Set<String> intersectionTest = new HashSet<>(nature);
        intersectionTest.retainAll(divine);

        System.out.println("Symmetric difference");
        unionTest.removeAll(intersectionTest);
        printSet(unionTest);

        if (nature.containsAll(divine)) {
            System.out.println("divine is a subset of nature");
        }

        if (nature.containsAll(intersectionTest)) {
            System.out.println("intersection is a subset of nature");
        }

        if (divine.containsAll(intersectionTest)) {
            System.out.println("intersection is a subset of divine");
        }


    }

    private static void printSet(Set<String> set)
    {
        System.out.println("\t");
        for (String s : set) {
            System.out.print(s + " ");
        }

        System.out.println();
    }
}
