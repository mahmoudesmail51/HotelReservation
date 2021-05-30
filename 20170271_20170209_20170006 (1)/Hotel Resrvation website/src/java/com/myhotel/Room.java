/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myhotel;

/**
 *
 * @author Mahmoud Esmail
 */
public class Room 
{
    int id;

    String type;
    int hotelID;
    int price;
    int capacity;
    boolean isBooked;

    public Room( String type, int hotelID, int price, int capacity, boolean isBooked) {
        
        this.type = type;
        this.hotelID = hotelID;
        this.price = price;
        this.capacity = capacity;
        this.isBooked = isBooked;
    }

    public Room(int id, String type, int hotelID, int price, int capacity, boolean isBooked) {
        this.id = id;
        
        this.type = type;
        this.hotelID = hotelID;
        this.price = price;
        this.capacity = capacity;
        this.isBooked = isBooked;
    }

    public int getId() {
        return id;
    }

    public void setId(int ID) {
        this.id = ID;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getHotelID() {
        return hotelID;
    }

    public void setHotelID(int hotelID) {
        this.hotelID = hotelID;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }
    
}
