package com.example.demo.RESTAPI;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Alien {
    @Id
    private int alienId;
    private String name;
    private int points;
    public Alien() {
    }
    public Alien(int alienId, String name, int points) {
        this.alienId = alienId;
        this.name = name;
        this.points = points;
    }
    public int getAlienId() {
        return alienId;
    }
    public void setAlienId(int alienId) {
        this.alienId = alienId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPoints() {
        return points;
    }
    public void setPoints(int points) {
        this.points = points;
    }
    @Override
    public String toString() {
        return "Alien [alienId=" + alienId + ", name=" + name + ", points=" + points + "]";
    }
}
