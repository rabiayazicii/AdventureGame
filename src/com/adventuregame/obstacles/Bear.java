package com.adventuregame.obstacles;

import com.adventuregame.entities.Obstacle;

/**
 * Bear obstacle - SRP principle
 * Sadece Bear engelinin özelliklerini içerir
 */
public class Bear extends Obstacle {
    public Bear() {
        super(3, 7, "Ayı", 20, 12);
    }
}
