package com.chrispeng.section9;

import java.util.ArrayList;

public class Album
{
    private ArrayList<Song> songs;

    public Album(ArrayList<Song> songs)
    {
        this.songs = songs;
    }

    public Album()
    {
        this.songs = new ArrayList<>();
    }

    public Song getSong(int index)
    {
        if (index >= songs.size() || index < 0) {
            return null;
        }
        return songs.get(index);
    }

    public void addSong(Song song)
    {
        songs.add(song);
    }
}
