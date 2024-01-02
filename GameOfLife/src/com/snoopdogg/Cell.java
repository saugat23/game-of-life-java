package com.snoopdogg;

public class Cell {
    private boolean alive;

    public Cell() {
        this.alive = false; // Initialize as dead
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
}
