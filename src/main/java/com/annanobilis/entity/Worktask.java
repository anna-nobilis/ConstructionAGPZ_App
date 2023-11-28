package com.annanobilis.entity;

public class Worktask {
    private int id;
    private String task;
    private String place;

    public Worktask() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return "Worktask{" +
                "id=" + id +
                ", task='" + task + '\'' +
                ", place='" + place + '\'' +
                '}';
    }
}
