package com.adventuregame.obstacles;

import com.adventuregame.entities.Obstacle;

/**
 * Vampire obstacle - SRP principle
 * Sadece Vampire engelinin özelliklerini içerir
 */
public class Vampire extends Obstacle {
    public Vampire() {
        super(2, 4, "Vampir", 14, 7);
    }
}
