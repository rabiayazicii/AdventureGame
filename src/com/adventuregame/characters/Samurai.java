package com.adventuregame.characters;

import com.adventuregame.entities.GameChar;

/**
 * Samurai character - SRP principle
 * Sadece Samurai karakterinin özelliklerini içerir
 */
public class Samurai extends GameChar {
    public Samurai() {
        super(1, "Samurai", 5, 21, 15);
    }
}
