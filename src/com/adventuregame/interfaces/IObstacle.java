package com.adventuregame.interfaces;

/**
 * Obstacle interface - ISP principle
 * Sadece engel özelliklerini içerir
 */
public interface IObstacle {
    int getId();
    String getName();
    int getDamage();
    int getHealth();
    int getAward();
    int getOrjinalHealth();
    void setHealth(int health);
}
