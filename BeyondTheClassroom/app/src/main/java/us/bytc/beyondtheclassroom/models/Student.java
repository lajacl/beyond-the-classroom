package us.bytc.beyondtheclassroom.models;

import java.util.Map;

/**
 * Created by LaVette_2 on 11/18/2017.
 */

public class Student {
    private String parent_id;
    private String username;
    private String password;
    private int grade;
    private int lexile_score;
    private Map<String,Boolean> books;
    private Map<String,Boolean> schedule;
//    private Map<String,Boolean> books_completed;

    public Student(){}

    public Student(String parent_id, String username, String password, int grade, int lexile_score, Map<String, Boolean> books, Map<String, Boolean> schedule) {
        this.parent_id = parent_id;
        this.username = username;
        this.password = password;
        this.grade = grade;
        this.lexile_score = lexile_score;
        this.books = books;
        this.schedule = schedule;
    }

    public String getParent_id() {
        return parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getLexile_score() {
        return lexile_score;
    }

    public void setLexile_score(int lexile_score) {
        this.lexile_score = lexile_score;
    }

    public Map<String, Boolean> getBooks() {
        return books;
    }

    public void setBooks(Map<String, Boolean> books) {
        this.books = books;
    }

    public Map<String, Boolean> getSchedule() {
        return schedule;
    }

    public void setSchedule(Map<String, Boolean> schedule) {
        this.schedule = schedule;
    }
}
