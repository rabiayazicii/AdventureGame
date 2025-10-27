package com.adventuregame.locations;

import com.adventuregame.entities.Player;
import com.adventuregame.obstacles.Snake;

/**
 * Maden - SRP principle
 * Sadece Maden location özelliklerini içerir
 * MadenAward sistemi CombatService'de handle ediliyor
 */
public class Maden extends BattleLoc {
    public Maden(Player player) {
        super(player, "Maden", new Snake(), 5);
    }
}