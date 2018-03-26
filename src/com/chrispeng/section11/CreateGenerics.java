package com.chrispeng.section11;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CreateGenerics
{
    public static void main(String[] args)
    {
        BasketballPlayer joe = new BasketballPlayer("Joe");
        BaseballPlayer pat = new BaseballPlayer("Pat");
        SoccerPlayer beckham = new SoccerPlayer("Beckham");

        Team<BasketballPlayer> crows = new Team<>("Crows");
        crows.addPlayer(joe);

        System.out.println(crows.numPlayers());

        Team<BaseballPlayer> bTeam = new Team<>("Cubs");
        bTeam.addPlayer(pat);

        Team<SoccerPlayer> madrid = new Team<>("Real Madrid");
        madrid.addPlayer(beckham);

//        Team<String> broken = new Team<String>("Broken");
//        broken.addPlayer("not a player");

        Team<SoccerPlayer> barsa = new Team<>("Barsadora");
        barsa.addPlayer(new SoccerPlayer("Messi"));

        Team<SoccerPlayer> racing = new Team<>("Madrid Racing");
        racing.addPlayer(new SoccerPlayer("Diago"));

        madrid.matchResult(barsa, 1, 1);
        madrid.matchResult(racing, 3, 1);
        System.out.println(madrid.compareTo(barsa));

        ArrayList<Team> spanishALeague = new ArrayList<>();
        spanishALeague.add(madrid);
        spanishALeague.add(barsa);
        spanishALeague.add(racing);
        Collections.sort(spanishALeague);
        for (Team t : spanishALeague) {
            System.out.println(t.getName() + " " +  t.ranking());
        }
    }
}
