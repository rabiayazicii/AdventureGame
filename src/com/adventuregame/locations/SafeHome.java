package com.adventuregame.locations;

import com.adventuregame.entities.Player;

/**
 * SafeHome - SRP principle
 * Sadece güvenli ev işlevlerini içerir
 */
public class SafeHome extends NormalLoc {
    public SafeHome(Player player) {
        super(player, "Güveli Ev");
    }

    @Override
    public boolean onLocation() {
        System.out.println("🏠 Güvenli evdesiniz! Canınız yenileniyor...");
        this.getPlayer().setHealth(this.getPlayer().getOrjinalHealth());
        System.out.println("❤️ Canınız yenilendi!");
        return true;
    }
}
