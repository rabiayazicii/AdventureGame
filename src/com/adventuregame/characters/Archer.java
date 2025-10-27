package com.adventuregame.characters;

import com.adventuregame.entities.GameChar;

/**
 * Archer character - SRP principle
 * Sadece Archer karakterinin özelliklerini içerir
 */
public class Archer extends GameChar {
    public Archer() {
        super(2, "Archer", 7, 18, 20);
    }
}
