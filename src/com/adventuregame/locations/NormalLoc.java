package com.adventuregame.locations;

import com.adventuregame.entities.Player;

/**
 * NormalLoc - SRP principle
 * Sadece normal location işlevlerini içerir
 */
public abstract class NormalLoc extends Location {
    public NormalLoc(Player player, String name) {
        super(player, name);
    }

    @Override
    public boolean onLocation() {
        return true;
    }
}
