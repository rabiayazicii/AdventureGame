package com.adventuregame.services;

import com.adventuregame.entities.Player;
import com.adventuregame.interfaces.ICombat;
import com.adventuregame.interfaces.IObstacle;
import com.adventuregame.items.Armor;
import com.adventuregame.items.Weapon;

import java.util.Random;
import java.util.Scanner;

/**
 * CombatService - SRP principle
 * Sadece savaş mantığını içerir
 */
public class CombatService implements ICombat {
    private Player player;
    private IObstacle obstacle;
    private Scanner input;

    public CombatService(Player player, IObstacle obstacle) {
        this.player = player;
        this.obstacle = obstacle;
        this.input = new Scanner(System.in);
    }

    @Override
    public boolean combat(int obstacleCount) {
        for (int i = 1; i <= obstacleCount; i++) {
            int firstAttacker = whoFirst();
            obstacle.setHealth(obstacle.getOrjinalHealth());

            playerStats();
            obstacleStats(i);

            System.out.println(firstAttacker == 1
                    ? "🍀 Şans sizden yana! İlk hamleyi siz yapıyorsunuz!"
                    : "⚡ Canavar hızlı davrandı! İlk hamleyi o yapıyor!");

            while (player.getHealth() > 0 && obstacle.getHealth() > 0) {
                if (firstAttacker == 1) {
                    System.out.println("-----------------------------------------");
                    System.out.println("<V>ur veya <K>aç");
                    String selectCombat = input.nextLine().toUpperCase();
                    if (selectCombat.equals("V")) {
                        System.out.println("💥 Siz vurdunuz !!");
                        obstacle.setHealth(obstacle.getHealth() - player.getDamage());
                        afterHit();
                        if (obstacle.getHealth() > 0) {
                            System.out.println("👾 Canavar size vurdu !");
                            int obstacleDamages = obstacle.getDamage() - player.getInventory().getArmor().getBlock();
                            if (obstacleDamages < 0) obstacleDamages = 0;
                            player.setHealth(player.getHealth() - obstacleDamages);
                            afterHit();
                        }
                    } else {
                        System.out.println("🏃 Kaçtınız! Menüye dönülüyor...");
                        return false; // Kaç'a basınca false dön ama özel kontrol yapılacak
                    }
                } else {
                    if (obstacle.getHealth() > 0) {
                        System.out.println();
                        System.out.println("-----------------------------------------");
                        System.out.println("👾 Canavar size vurdu !");
                        int obstacleDamages = obstacle.getDamage() - player.getInventory().getArmor().getBlock();
                        if (obstacleDamages < 0) obstacleDamages = 0;
                        player.setHealth(player.getHealth() - obstacleDamages);
                        afterHit();

                        System.out.println("-----------------------------------------");
                        System.out.println("<V>ur veya <K>aç");
                        String selectCombat = input.nextLine().toUpperCase();
                        if (selectCombat.equals("V")) {
                            System.out.println("💥 Siz vurdunuz !!");
                            obstacle.setHealth(obstacle.getHealth() - player.getDamage());
                            afterHit();
                        } else {
                        System.out.println("🏃 Kaçtınız! Menüye dönülüyor...");
                        return false; // Kaç'a basınca false dön ama özel kontrol yapılacak
                    }
                    }
                }
            }

            if (obstacle.getHealth() < player.getHealth()) {
                System.out.println("-----------------------------------------");
                System.out.println("🎉 Düşmanı yendiniz !");
                System.out.println("-----------------------------------------");
                
                // Maden için özel ödül sistemi - eski kod mantığı
                if (obstacle.getName().equals("Yılan")) {
                    MadenAward();
                } else {
                    // Diğer bölgeler için normal para ödülü
                    if (obstacle.getAward() > 0) {
                        System.out.println("💰 " + obstacle.getAward() + " ₺ Para kazandınız!");
                        player.setMoney(obstacle.getAward() + player.getMoney());
                        System.out.println("🪙 Güncel paranız: " + player.getMoney());
                    }
                }
            } else return false;
        }
        return true;
    }

    @Override
    public int whoFirst() {
        Random r = new Random();
        return r.nextInt(2);
    }

    @Override
    public void afterHit() {
        System.out.println("❤️ Canınız: " + player.getHealth());
        System.out.println("👾 " + obstacle.getName() + " Canı: " + obstacle.getHealth());
    }

    @Override
    public void playerStats() {
        System.out.println("═════════════════════════════════");
        System.out.println("🧑 Oyuncu Değerleri");
        System.out.println("═════════════════════════════════");
        System.out.println("❤️ Sağlık: " + player.getHealth());
        System.out.println("💥 Silah: " + player.getInventory().getWeapon().getName());
        System.out.println("🛡️ Zırh: " + player.getInventory().getArmor().getName());
        System.out.println("⚔️ Hasar: " + player.getTotalDamage());
        System.out.println("🛡️ Bloklama: " + player.getInventory().getArmor().getBlock());
        System.out.println("💰 Para: " + player.getMoney());
        System.out.println("═════════════════════════════════");
    }

    @Override
    public void obstacleStats(int i) {
        System.out.println("═════════════════════════════════");
        System.out.println("👾 " + i + ". " + obstacle.getName() + " Değerleri");
        System.out.println("═════════════════════════════════");
        System.out.println("❤️ Sağlık: " + obstacle.getHealth());
        System.out.println("⚔️ Hasar: " + obstacle.getDamage());
        System.out.println("💰 Ödül: " + obstacle.getAward() + " ₺");
        System.out.println("═════════════════════════════════");
    }

    public void MadenAward() {
        Random r = new Random();
        int chance = r.nextInt(100) + 1;

        if (chance <= 15) {
            int chanceWeapon = r.nextInt(100) + 1;
            if (chanceWeapon <= 20) {
                Weapon tabanca = new Weapon("Tabanca", 1, 2, 1);
                this.player.getInventory().setWeapon(tabanca);
                System.out.println("🔫 Tabanca kazandınız!");
            } else if (chanceWeapon <= 50) {
                Weapon kilic = new Weapon("Kılıç", 2, 3, 35);
                this.player.getInventory().setWeapon(kilic);
                System.out.println("⚔️ Kılıç kazandınız!");
            } else if (chanceWeapon <= 100) {
                Weapon tufek = new Weapon("Tüfek", 3, 7, 45);
                this.player.getInventory().setWeapon(tufek);
                System.out.println("🎯 Tüfek kazandınız: " + tufek.getName());
            }
        } else if (chance <= 30) {
            int zırh = r.nextInt(100) + 1;
            if (zırh <= 20) {
                Armor agir = new Armor("Ağır", 3, 5, 40);
                this.player.getInventory().setArmor(agir);
                System.out.println("🏰 Ağır zırh kazandınız!");
            } else if (zırh <= 45) {
                Armor orta = new Armor("Orta", 2, 3, 25);
                this.player.getInventory().setArmor(orta);
                System.out.println("🛡️ Orta zırh kazandınız!");
            } else if (zırh <= 100) {
                Armor hafif = new Armor("Hafif", 1, 1, 15);
                this.player.getInventory().setArmor(hafif);
                System.out.println("🥋 Hafif zırh kazandınız!");
            }
        } else if (chance <= 55) {
            int money = r.nextInt(100) + 1;
            if (money <= 20) {
                this.player.setMoney(this.player.getMoney() + 10);
                System.out.println("💰 10₺ para kazandınız! Yeni paranız: " + this.player.getMoney() + " ₺");
            } else if (money <= 50) {
                this.player.setMoney(this.player.getMoney() + 5);
                System.out.println("💰 5₺ para kazandınız! Yeni paranız: " + this.player.getMoney() + " ₺");
            } else if (money <= 100) {
                this.player.setMoney(this.player.getMoney() + 1);
                System.out.println("💰 1₺ para kazandınız! Yeni paranız: " + this.player.getMoney() + " ₺");
            }
        } else {
            System.out.println("❌ Hiçbir şey kazanamadınız...");
        }
    }
}
