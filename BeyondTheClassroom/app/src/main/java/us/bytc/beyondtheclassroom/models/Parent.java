package us.bytc.beyondtheclassroom.models;


import java.util.Map;

/**
 * Created by LaVette_2 on 11/18/2017.
 */

public class Parent {
    private String email;
    private String name;
    private int payment_tier;
    private String phone;
    private float hours_left;
    private Map<String,Boolean> students;

    public Parent(){}

    public Parent(String email, String name, int payment_tier, String phone,
                  float hours_left, Map<String, Boolean> students) {
        this.email = email;
        this.name = name;
        this.payment_tier = payment_tier;
        this.phone = phone;
        this.hours_left = hours_left;
        this.students = students;
    }

    public String getEmail() { return email; }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPayment_tier() {
        return payment_tier;
    }

    public void setPayment_tier(int payment_tier) {
        this.payment_tier = payment_tier;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public float getHours_left() {
        return hours_left;
    }

    public void setHours_left(float hours_left) {
        this.hours_left = hours_left;
    }

    public Map<String, Boolean> getStudents() {
        return students;
    }

    public void setStudents(Map<String, Boolean> students) {
        this.students = students;
    }
}
