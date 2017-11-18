package us.bytc.beyondtheclassroom.models;

/**
 * Created by LaVette_2 on 11/18/2017.
 */

public class Session {
    private String teacher_id;
    private String student_id;
    private String date;
    private String start_time;
    private String length;
    private float pay_rate;

    private Session(){}

    public Session(String teacher_id, String student_id, String date, String start_time, String length, float pay_rate) {
        this.teacher_id = teacher_id;
        this.student_id = student_id;
        this.date = date;
        this.start_time = start_time;
        this.length = length;
        this.pay_rate = pay_rate;
    }

    public String getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(String teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public float getPay_rate() {
        return pay_rate;
    }

    public void setPay_rate(float pay_rate) {
        this.pay_rate = pay_rate;
    }
}
