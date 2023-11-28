package com.annanobilis.entity;

public class Employee {
    private int id;
    private String name;
    private String post;
    private double experience;
    private Worktask worktask;


    public Employee(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public double getExperience() {
        return experience;
    }

    public void setExperience(double experience) {
        this.experience = experience;
    }

    public Worktask getWorktask() {
        return worktask;
    }

    public void setWorktask(Worktask worktask) {
        this.worktask = worktask;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", post='" + post + '\'' +
                ", experience=" + experience +
                ", worktask=" + worktask +
                '}';
    }
}
