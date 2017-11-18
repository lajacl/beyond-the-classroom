package us.bytc.beyondtheclassroom.models;

import java.util.Map;

/**
 * Created by LaVette_2 on 11/18/2017.
 */

public class Teacher {
    private String email;
    private String bio;
    private String phone;
    private String photo_url;
    private Map<String,Boolean> schedule;
//    private Map<String,Boolean> grades;

    public Teacher(){}

    public Teacher(String email, String bio, String phone, String photo_url, Map<String, Boolean> schedule) {
        this.email = email;
        this.bio = bio;
        this.phone = phone;
        this.photo_url = photo_url;
        this.schedule = schedule;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }

    public Map<String, Boolean> getSchedule() {
        return schedule;
    }

    public void setSchedule(Map<String, Boolean> schedule) {
        this.schedule = schedule;
    }
}
