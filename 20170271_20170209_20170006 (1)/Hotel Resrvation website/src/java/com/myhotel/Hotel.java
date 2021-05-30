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
public class Hotel {
    
    private int id;
    private String hotelName;
    private String availability;
    private float expectedPrice;
    private String rating;
    private String city;
    private String imageUrl;
    private String location;

    public Hotel(String hotelName, String availability, float expectedPrice, String rating, String city, String imageUrl, String location) {
        this.hotelName = hotelName;
        this.availability = availability;
        this.expectedPrice = expectedPrice;
        this.rating = rating;
        this.city = city;
        this.imageUrl = imageUrl;
        this.location = location;
    }

    public Hotel(int id, String hotelName, String availability, float expectedPrice, String rating, String city, String imageUrl, String location) {
        this.id = id;
        this.hotelName = hotelName;
        this.availability = availability;
        this.expectedPrice = expectedPrice;
        this.rating = rating;
        this.city = city;
        this.imageUrl = imageUrl;
        
        
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public float getExpectedPrice() {
        return expectedPrice;
    }

    public void setExpectedPrice(float expectedPrice) {
        this.expectedPrice = expectedPrice;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
    
    
}
