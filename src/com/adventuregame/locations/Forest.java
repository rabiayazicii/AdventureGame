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

    @Override
    public boolean onLocation() {
        boolean result = super.onLocation();
        
        // Tüm düşmanlar yenildiyse ödül ver
        if (result && this.getPlayer().getHealth() > 0) {
            this.getPlayer().getInventory().setFirewood(true);
            System.out.println("🎉 🪵 Firewood ödülünü kazandınız!");
        }
        
        return result;
    }
}
