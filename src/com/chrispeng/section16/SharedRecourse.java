package com.chrispeng.section16;

public class SharedRecourse
{
    private Worker owner;

    public SharedRecourse(Worker owner)
    {
        this.owner = owner;
    }

    public Worker getOwner()
    {
        return owner;
    }

    public synchronized void setOwner(Worker owner)
    {
        this.owner = owner;
    }
}
