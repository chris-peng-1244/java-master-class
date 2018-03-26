package com.chrispeng.section9;

import java.util.Scanner;

public class LinkedListChallenge
{
    public static void main(String[] args)
    {
        Album album1 = new Album();
        album1.addSong(Song.create("Beat it", 180));
        album1.addSong(Song.create("Dreamland", 200));
        Album album2 = new Album();
        album2.addSong(Song.create("Defeated", 150));
        album2.addSong(Song.create("Vorocias", 190));

        Playlist playlist = new Playlist();
        playlist.addSong(album1, 0);
        playlist.addSong(album1, 1);
        playlist.addSong(album2, 0);
        playlist.addSong(album2, 1);

        play(playlist);
    }

    private static void play(Playlist playlist)
    {
        boolean quit = false;
        Scanner scanner = new Scanner(System.in);
        Song song = playlist.play();
        printSong(song);

        while (!quit) {
            int input = scanner.nextInt();
            switch (input) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    song = playlist.next();
                    printSong(song);
                    break;
                case 2:
                    song = playlist.previous();
                    printSong(song);
                    break;
                case 3:
                    song = playlist.repeat();
                    printSong(song);
                    break;
                default:
                    printMenu();
            }
        }
    }

    private static void printMenu()
    {
        System.out.println("I am to lazy to write the menu");
    }

    private static void printSong(Song song)
    {
        if (null == song) {
            System.out.println("No song");
            return;
        }
        System.out.println("Play song " + song.getTitle() + " for " + song.getDuration() + " seconds");
    }
}
