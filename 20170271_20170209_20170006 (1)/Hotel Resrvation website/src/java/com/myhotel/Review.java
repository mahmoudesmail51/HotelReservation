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
public class Review {
    private int id;
    private int hotelId;
    private int customerId;
    private String comment;
    private String stars;

    public Review(int id, int hotelId, int customerId, String comment, String stars) {
        this.id = id;
        this.hotelId = hotelId;
        this.customerId = customerId;
        this.comment = comment;
        this.stars = stars;
    }

    public Review(int hotelId, int customerId, String comment, String stars) {
        this.hotelId = hotelId;
        this.customerId = customerId;
        this.comment = comment;
        this.stars = stars;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }
    
    
}
