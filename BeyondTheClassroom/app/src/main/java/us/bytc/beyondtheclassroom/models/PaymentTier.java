package us.bytc.beyondtheclassroom.models;

/**
 * Created by LaVette_2 on 11/18/2017.
 */

public class PaymentTier {
    private  int hours_per_month;
    private float price;

    public PaymentTier(){}

    public PaymentTier(int hours_per_month, float price) {
        this.hours_per_month = hours_per_month;
        this.price = price;
    }

    public int getHours_per_month() {
        return hours_per_month;
    }

    public void setHours_per_month(int hours_per_month) {
        this.hours_per_month = hours_per_month;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
