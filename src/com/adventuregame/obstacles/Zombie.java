package com.adventuregame.obstacles;

import com.adventuregame.entities.Obstacle;

/**
 * Zombie obstacle - SRP principle
 * Sadece Zombie engelinin özelliklerini içerir
 */
public class Zombie extends Obstacle {
    public Zombie() {
        super(1, 3, "Zombi", 10, 4);
    }
}
