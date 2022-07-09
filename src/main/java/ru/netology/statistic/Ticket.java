package ru.netology.statistic;

import org.jetbrains.annotations.NotNull;

public class Ticket implements Comparable <Ticket> {
    private int id;
    private int price;
    private String departureAir;
    private String arrivalAir;
    private int travelTime;


    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDepartureAir(String departureAir) {
        this.departureAir = departureAir;
    }

    public void setArrivalAir(String arrivalAir) {
        this.arrivalAir = arrivalAir;
    }

    public void setTravelTime(int travelTime) {
        this.travelTime = travelTime;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public String getDepartureAir() {
        return departureAir;
    }

    public String getArrivalAir() {
        return arrivalAir;
    }

    public int getTravelTime() {
        return travelTime;
    }

    public Ticket(int id, int price, String departureAir, String arrivalAir, int travelTime) {
        this.id = id;
        this.price = price;
        this.departureAir = departureAir;
        this.arrivalAir = arrivalAir;
        this.travelTime = travelTime;
    }

    @Override
    public int compareTo(Ticket otherTicket) {
        if (price < otherTicket.price) {
            return -1;
        }
        if (price > otherTicket.price) {
            return 1;
        }
        return 0;
    }
}
