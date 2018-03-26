package com.chrispeng.section13;

import java.util.HashMap;
import java.util.Map;

public class HashCourse
{
    public static void main(String[] args)
    {
        Map<String, String> languages = new HashMap<>();
        languages.put("Java", "a compiled high level, object-oriented, platform independent language");
        languages.put("Python", "an interpretedd, object-oriented, high-level programming language dynamic semantics");
        languages.put("Algol", " an algorithm language");
        System.out.println(languages.put("BASIC", "beginners all purpses symbolic instruction code"));
        languages.put("Lisp", "Therein lies madness");

        if (languages.containsKey("Java")) {
            System.out.println("Java is already in the languages");
        } else {
            System.out.println(languages.put("Java", "this course is about Java"));
        }
//        System.out.println(languages.get("Java"));
//        System.out.println(languages.get("Java"));

        languages.remove("Lisp");
        if (languages.remove("Algol", "a familiy of alogrithm languages")) {
            System.out.println("Algol removed");
        } else {
            System.out.println("Algol not removed");
        }
        System.out.println(languages.replace("Lisp", "a functional programming language"));
        System.out.println(languages.replace("Scala", "this will not be added"));
        for (String key : languages.keySet()) {
            System.out.println(key + " : " + languages.get(key));
        }
    }
}
