package com.adventuregame.characters;

import com.adventuregame.entities.GameChar;

/**
 * Knight character - SRP principle
 * Sadece Knight karakterinin özelliklerini içerir
 */
public class Knight extends GameChar {
    public Knight() {
        super(3, "Knight", 8, 24, 5);
    }
}
