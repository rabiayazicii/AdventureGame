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

    @Override
    public boolean onLocation() {
        boolean result = super.onLocation();
        
        // Tüm düşmanlar yenildiyse ödül ver
        if (result && this.getPlayer().getHealth() > 0) {
            this.getPlayer().getInventory().setWater(true);
            System.out.println("🎉 💧 Water ödülünü kazandınız!");
        }
        
        return result;
    }
}
