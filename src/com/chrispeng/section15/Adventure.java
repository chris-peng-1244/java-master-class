package com.chrispeng.section15;

import com.chrispeng.section13.Location;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Adventure
{
    private static Locations locations = new Locations();

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> vocabulary = new HashMap<>();
        vocabulary.put("QUIT", "Q");
        vocabulary.put("NORTH", "N");
        vocabulary.put("SOUTH", "S");
        vocabulary.put("WEST", "W");
        vocabulary.put("EAST", "E");

        int loc = 1;
        while (true) {
            System.out.println(locations.get(loc).getDescription());
            if (loc == 0) {
                break;
            }

            Map<String, Integer> exits = locations.get(loc).getExits();
            System.out.println("Available exists are ");
            for (String exit: exits.keySet()) {
                System.out.print(exit + ", ");
            }
            System.out.println();

            String input = scanner.nextLine();
            String direction = "";
            if (input.length() == 1) {
                direction = input.toUpperCase();
            } else {
                String[] words = input.split(" ");
                for (String word : words) {
                    word = word.toUpperCase();
                    if (vocabulary.containsKey(word)) {
                        direction = vocabulary.get(word);
                        break;
                    }
                }
            }

            if (direction.compareTo("") == 0) {
                System.out.println("Invalid direction, stay");
                continue;
            }

            if (exits.containsKey(direction)) {
                loc = exits.get(direction);
            } else {
                System.out.println("You cannot go in that direction");
            }

            if (!locations.containsKey(loc)) {
                System.out.println("You cannot go in that direction");
            }
        }
    }
}
