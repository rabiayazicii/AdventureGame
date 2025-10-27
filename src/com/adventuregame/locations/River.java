package com.adventuregame.locations;

import com.adventuregame.entities.Player;
import com.adventuregame.obstacles.Bear;

/**
 * River - SRP principle
 * Sadece nehir işlevlerini içerir
 */
public class River extends BattleLoc {
    public River(Player player) {
        super(player, "Nehir", new Bear(), 5);
    }
}
