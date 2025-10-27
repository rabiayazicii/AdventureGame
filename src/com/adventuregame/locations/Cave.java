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

    @Override
    public boolean onLocation() {
        boolean result = super.onLocation();
        
        // Tüm düşmanlar yenildiyse ödül ver
        if (result && this.getPlayer().getHealth() > 0) {
            this.getPlayer().getInventory().setFood(true);
            System.out.println("🎉 🍖 Food ödülünü kazandınız!");
        }
        
        return result;
    }
}
