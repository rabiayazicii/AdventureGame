package com.adventuregame.entities;

import com.adventuregame.interfaces.IObstacle;

/**
 * Obstacle entity - SRP principle
 * Sadece engel özelliklerini içerir
 */
public class Obstacle implements IObstacle {
    private int id;
    private int damage;
    private int health;
    private String name;
    private int award;
    private int originalHealth;

    public Obstacle(int id, int damage, String name, int health, int award) {
        this.id = id;
        this.damage = damage;
        this.name = name;
        this.health = health;
        this.award = award;
        this.originalHealth = health;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getDamage() { return damage; }
    public void setDamage(int damage) { this.damage = damage; }

    public int getHealth() { return health; }
    public void setHealth(int health) {
        if (health < 0) {
            health = 0;
        }
        this.health = health;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAward() { return award; }
    public void setAward(int award) { this.award = award; }

    public int getOrjinalHealth() { return originalHealth; }
    public void setOrjinalHealth(int originalHealth) { this.originalHealth = originalHealth; }
}
