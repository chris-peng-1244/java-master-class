package com.chrispeng.section13;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Theatre
{
    private final String theatreName;
    private List<Seat> seats = new ArrayList<>();

    static final Comparator<Seat> PRICE_ORDER;

    static {
        PRICE_ORDER = new Comparator<Seat>()
        {
            @Override
            public int compare(Seat seat1, Seat seat2)
            {
                if (seat1.getPrice() < seat2.getPrice()) {
                    return -1;
                } else if (seat1.getPrice() > seat2.getPrice()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        };
    }

    public String getTheatreName()
    {
        return theatreName;
    }

    public Theatre(String theatreName, int numRows, int seatsPerRow)
    {
        this.theatreName = theatreName;

        int lastRow = 'A' + (numRows - 1);
        for (char row = 'A'; row <= lastRow; row++) {
            for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
                double price = getSeatPrice(row, seatNum);
                Seat seat = new Seat(row + String.format("%02d", seatNum), price);
                seats.add(seat);
            }
        }
    }

    private double getSeatPrice(char row, int seatNum)
    {
        double price = 12.0;
        if ((row < 'D') && (seatNum >= 4 && seatNum <= 9)) {
            price = 14.0;
        } else if ((row > 'F') || (seatNum < 4 || seatNum > 9)) {
            price = 7.0;
        }
        return price;
    }

    public boolean reserveSeat(String seatNumber)
    {
        Seat requestedSeat = new Seat(seatNumber, 0);
        int findSeat = Collections.binarySearch(seats, requestedSeat, null);
        if (findSeat >= 0) {
            return seats.get(findSeat).reserve();
        }
        System.out.println("There is no seat " + seatNumber);
        return false;
    }

    public void getSeats()
    {
        for (Seat seat : seats) {
            System.out.println(seat.getSeatNumber());
        }
    }

    public List<Seat> getSeatList()
    {
        return seats;
    }

    class Seat implements Comparable<Seat>
    {
        private final String seatNumber;
        private double price;
        private boolean reserved = false;

        public Seat(String seatNumber, double price)
        {
            this.seatNumber = seatNumber;
            this.price = price;
        }

        public boolean reserve()
        {
            if (!this.reserved) {
                this.reserved = true;
                System.out.println("Seat " + seatNumber + " reserved");
                return true;
            }
            return false;
        }

        public boolean cancel()
        {
            if (this.reserved) {
                this.reserved = false;
                System.out.println("Seat " + seatNumber + " cancelled");
                return true;
            }
            return false;
        }

        public String getSeatNumber()
        {
            return seatNumber;
        }

        public double getPrice()
        {
            return price;
        }

        @Override
        public int compareTo(Seat seat)
        {
            return getSeatNumber().compareToIgnoreCase(seat.getSeatNumber());
        }
    }
}
