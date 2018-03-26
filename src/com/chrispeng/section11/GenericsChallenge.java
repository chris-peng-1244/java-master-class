package com.chrispeng.section11;

public class GenericsChallenge
{
    public static void main(String[] args)
    {
        League<Team<SoccerPlayer>> spanishSuper = new League<>("Spanish Super");

        SoccerPlayer beckham = new SoccerPlayer("Beckham");
        Team<SoccerPlayer> madrid = new Team<>("Real Madrid");
        madrid.addPlayer(beckham);

        Team<SoccerPlayer> barsa = new Team<>("Barsadora");
        barsa.addPlayer(new SoccerPlayer("Messi"));

        Team<SoccerPlayer> racing = new Team<>("Madrid Racing");
        racing.addPlayer(new SoccerPlayer("Diago"));

        madrid.matchResult(barsa, 1, 1);
        madrid.matchResult(racing, 3, 1);

        Team<BasketballPlayer> laker = new Team<>("Laker");
        laker.addPlayer(new BasketballPlayer("Koby"));

        spanishSuper.addTeam(madrid);
        spanishSuper.addTeam(barsa);
        spanishSuper.addTeam(racing);
        System.out.println(madrid.compareTo(barsa));
        spanishSuper.printTeams();
    }
}
