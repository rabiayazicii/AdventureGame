package com.adventuregame.entities;

import com.adventuregame.characters.Archer;
import com.adventuregame.characters.Knight;
import com.adventuregame.characters.Samurai;
import com.adventuregame.interfaces.ICharacter;
import com.adventuregame.inventory.Inventory;

import java.util.Scanner;

/**
 * Player entity - SRP principle
 * Sadece oyuncu bilgilerini ve temel işlevlerini içerir
 */
public class Player {
    private int damage;
    private int health;
    private int money;
    private String charName;
    private String name;
    private Inventory inventory;
    private int originalHealth;

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }

    public void printInfo() {
        System.out.println("═════════════════════════════════");
        System.out.println("🧑 Oyuncu Bilgileri: " + this.getName());
        System.out.println("💥 Silah: " + this.getInventory().getWeapon().getName());
        System.out.println("🛡️ Zırh: " + this.getInventory().getArmor().getName());
        System.out.println("⚔️ Hasar: " + this.getTotalDamage());
        System.out.println("❤️ Sağlık: " + this.getHealth());
        System.out.println("💰 Para: " + this.getMoney());
        System.out.println("═════════════════════════════════");
    }

    public void selectChar() {
        ICharacter[] charList = {new Samurai(), new Archer(), new Knight()};

        System.out.println("📜 Karakterler:");
        for (ICharacter gamechar : charList) {
            System.out.println(
                    "ID: " + gamechar.getId() +
                            " | Karakter: " + gamechar.getName() +
                            " | ⚔️ Hasar: " + gamechar.getDamage() +
                            " | ❤️ Sağlık: " + gamechar.getHealth() +
                            " | 💰 Para: " + gamechar.getMoney()
            );
        }

        Scanner input = new Scanner(System.in);
        System.out.println("Lütfen karakterinizi seçiniz (ID giriniz): ");
        int selectchar = input.nextInt();

        switch (selectchar) {
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());
        }

        System.out.println("✅ Seçilen Karakter: " + this.charName +
                " | ⚔️ Hasar: " + this.damage +
                " | ❤️ Sağlık: " + this.health +
                " | 💰 Para: " + this.money);
        System.out.println("═════════════════════════════════");
    }

    public void initPlayer(ICharacter gameChar) {
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setOrjinalHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setCharName(gameChar.getName());
    }

    public int getTotalDamage() {
        return damage + this.getInventory().getWeapon().getDamage();
    }

    // Getters and Setters
    public int getDamage() { return damage; }
    public void setDamage(int damage) { this.damage = damage; }

    public int getHealth() { return health; }
    public void setHealth(int health) {
        this.health = Math.max(health, 0);
    }

    public int getMoney() { return money; }
    public void setMoney(int money) { this.money = money; }

    public String getCharName() { return charName; }
    public void setCharName(String charName) { this.charName = charName; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Inventory getInventory() { return inventory; }
    public void setInventory(Inventory inventory) { this.inventory = inventory; }

    public int getOrjinalHealth() { return originalHealth; }
    public void setOrjinalHealth(int originalHealth) { this.originalHealth = originalHealth; }
}
