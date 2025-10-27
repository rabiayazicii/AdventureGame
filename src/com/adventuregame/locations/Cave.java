package com.adventuregame.locations;

import com.adventuregame.entities.Player;
import com.adventuregame.obstacles.Zombie;

/**
 * Cave - SRP principle
 * Sadece mağara işlevlerini içerir
 */
public class Cave extends BattleLoc {
    public Cave(Player player) {
        super(player, "Mağara", new Zombie(), 3);
    }
}
