package com.chrispeng.section13;

public class Course1
{
    public static void main(String[] args)
    {
        Theatre theatre = new Theatre("Olympia", 8, 12);
        theatre.getSeats();
        if (theatre.reserveSeat("H11")) {
            System.out.println("Please pay");
        } else {
            System.out.println("Sorry, seat is taken");
        }
        if (theatre.reserveSeat("H11")) {
            System.out.println("Please pay");
        } else {
            System.out.println("Sorry, seat is taken");
        }
    }
}
