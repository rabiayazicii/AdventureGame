package com.adventuregame.locations;

import com.adventuregame.entities.Player;
import com.adventuregame.interfaces.IObstacle;
import com.adventuregame.services.CombatService;

import java.util.Random;

/**
 * BattleLoc - SRP principle
 * Sadece savaş location işlevlerini içerir
 */
public abstract class BattleLoc extends Location {
    private IObstacle obstacle;
    private int maxObstacle;

    public BattleLoc(Player player, String name, IObstacle obstacle, int maxObstacle) {
        super(player, name);
        this.obstacle = obstacle;
        this.maxObstacle = maxObstacle;
    }

    @Override
    public boolean onLocation() {
        int obsNumber = randomobstaclenumber();

        System.out.println("-----------------------------------------");
        System.out.println("📍 Şuan buradasınız : " + this.getName());
        System.out.println("⚠️ Dikkatli ol ! Burada " + obsNumber + " adet " + this.getObstacle().getName() + " yaşıyor !");
        System.out.println("<S>avaş veya <K>aç : ");
        String selectBattleCase = input.nextLine();
        selectBattleCase = selectBattleCase.toUpperCase();

        if (selectBattleCase.equals("S")) {
            CombatService combatService = new CombatService(player, obstacle);
            
            if (combatService.combat(obsNumber)) {
                System.out.println("-----------------------------------------");
                System.out.println("🏁 " + this.getName() + " tüm düşmanları yendiniz !");
                return true;
            }
        }
        if (this.getPlayer().getHealth() <= 0) {
            System.out.println("-----------------------------------------");
            System.out.println("💀 Öldünüz !");
            return false;
        }
        return true;
    }

    private int randomobstaclenumber() {
        Random r = new Random();
        return r.nextInt(this.getMaxObstacle()) + 1;
    }

    // Getters and Setters
    public IObstacle getObstacle() { return obstacle; }
    public void setObstacle(IObstacle obstacle) { this.obstacle = obstacle; }

    public int getMaxObstacle() { return maxObstacle; }
    public void setMaxObstacle(int maxObstacle) { this.maxObstacle = maxObstacle; }
}
