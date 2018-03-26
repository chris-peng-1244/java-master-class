package com.chrispeng.section9;

import java.util.LinkedList;
import java.util.ListIterator;

public class Playlist
{
    private LinkedList<Song> songs = new LinkedList<>();
    private boolean goingForward = true;

    private ListIterator<Song> songListIterator;

    public boolean addSong(Album album, int songIndex)
    {
        Song song = album.getSong(songIndex);
        if (song != null) {
            songs.add(song);
            return true;
        }
        return false;
    }

    public Song play()
    {
        if (songs.size() == 0) {
            return null;
        }
        songListIterator = songs.listIterator();
        return songListIterator.next();
    }

    public Song next()
    {
        if (!goingForward) {
            songListIterator.next();
            goingForward = true;
        }
        if (songListIterator.hasNext()) {
            return songListIterator.next();
        } else {
            goingForward = false;
        }
        return null;
    }

    public Song previous()
    {
        if (goingForward) {
            songListIterator.previous();
            goingForward = false;
        }
        if (songListIterator.hasPrevious()) {
            return songListIterator.previous();
        } else {
            goingForward = true;
        }
        return null;
    }

    public Song repeat()
    {
        Song song = null;
        if (goingForward && songListIterator.hasPrevious()) {
            song = songListIterator.previous();
            songListIterator.next();
        } else if (!goingForward && songListIterator.hasNext()) {
            song = songListIterator.next();
            songListIterator.previous();
        }
        return song;
    }
}
