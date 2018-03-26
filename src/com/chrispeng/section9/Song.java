package com.chrispeng.section9;

public class Song
{
    private String title;
    /**
     * Duration is measured in seconds
     */
    private int duration;

    private Song(String title, int duration)
    {
        this.title = title;
        this.duration = duration;
    }

    public static Song create(String title, int duration)
    {
        return new Song(title, duration);
    }

    public int getDuration()
    {
        return duration;
    }

    public String getTitle()
    {
        return title;
    }
}
