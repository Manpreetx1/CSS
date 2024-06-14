package com.example.assignonejava;

public class FlightData {
    private String review;
    private int delay;
    private double price;
    private int comfort;
    private int complaints;

    public FlightData(String review, int delay, double price, int comfort, int complaints) {
        this.review = review;
        this.delay = delay;
        this.price = price;
        this.comfort = comfort;
        this.complaints = complaints;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getComfort() {
        return comfort;
    }

    public void setComfort(int comfort) {
        this.comfort = comfort;
    }

    public int getComplaints() {
        return complaints;
    }

    public void setComplaints(int complaints) {
        this.complaints = complaints;
    }
}
