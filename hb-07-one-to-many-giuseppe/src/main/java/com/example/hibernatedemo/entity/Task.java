package com.example.hibernatedemo.entity;


import javax.persistence.*;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int Id;

    @Column(name = "task_name")
    private String taskName;

    @Column(name = "minutes")
    private int minutes;


    @ManyToOne(cascade = CascadeType.ALL)
    private Employee employee;


    public Task() {
    }

    public Task(String taskName, int minutes) {
        this.taskName = taskName;
        this.minutes = minutes;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }
}
