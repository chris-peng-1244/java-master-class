package com.chrispeng.section11;

import java.util.ArrayList;
import java.util.Collections;

public class League<T extends Team>
{
    ArrayList<T> teams = new ArrayList<>();
    private String name;

    public League(String name)
    {
        this.name = name;
    }

    public boolean addTeam(T team)
    {
        if (teams.contains(team)) {
            return false;
        }
        teams.add(team);
        return true;
    }

    public void printTeams()
    {
        Collections.sort(teams);
        for (T t : teams) {
            System.out.println(t.getName() + ": " + t.ranking());
        }
    }
}
