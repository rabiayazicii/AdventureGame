package com.adventuregame.locations;

import com.adventuregame.entities.Player;
import com.adventuregame.obstacles.Vampire;

/**
 * Forest - SRP principle
 * Sadece orman işlevlerini içerir
 */
public class Forest extends BattleLoc {
    public Forest(Player player) {
        super(player, "Orman", new Vampire(), 4);
    }
}
