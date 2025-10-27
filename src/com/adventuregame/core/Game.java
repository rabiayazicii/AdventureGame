package com.adventuregame.core;

import com.adventuregame.entities.Player;
import com.adventuregame.interfaces.ILocation;
import com.adventuregame.locations.*;

import java.util.Scanner;

/**
 * Game - SRP principle
 * Sadece oyun akışını yönetir
 * DIP principle - Interface'lere bağımlılık
 */
public class Game {
    private Scanner input = new Scanner(System.in);
    private Player player;

    public void start() {
        System.out.println("═════════════════════════════════");
        System.out.println("🎮 Macera Oyununa Hoşgeldiniz!");
        System.out.println("Lütfen bir isim giriniz: ");
        String playerName = input.nextLine();
        player = new Player(playerName);
        System.out.println("✨ " + player.getName() + ", bu karanlık ve sisli adaya hoşgeldiniz!");
        System.out.println("⚠️ Burada yaşananların hepsi gerçek!");
        System.out.println("Lütfen bir karakter seçiniz:");
        player.selectChar();

        ILocation location = null;
        while (true) {
            System.out.println("═════════════════════════════════");
            player.printInfo();
            System.out.println("📍 Bölgeler:");
            System.out.println("1 - 🏠 Güvenli Ev       --> Canınız yenilenir");
            System.out.println("2 - 🏪 Mağaza           --> Silah ve zırh satın al");
            System.out.println("3 - 🦇 Mağara           --> Ödül: 🍖 Food | Düşman: Zombi");
            System.out.println("4 - 🌲 Orman            --> Ödül: 🪵 Firewood | Düşman: Vampir");
            System.out.println("5 - 🌊 Nehir            --> Ödül: 💧 Water | Düşman: Ayı");
            System.out.println("6 - ⛏️ Maden             --> Ödül: 🎁 Loot | Düşman: Yılan");
            System.out.println("0 - ❌ ÇIKIŞ             --> Oyundan çık");
            System.out.println("Lütfen gitmek istediğiniz bölgeyi seçiniz: ");
            int loc = input.nextInt();
            
            switch (loc) {
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHome(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    if (player.getInventory().isFood()) {
                        System.out.println("ℹ️ Bu bölgenin ödülünü zaten kazandınız! Tekrar giremezsiniz!");
                        continue;
                    } else {
                        location = new Cave(player);
                    }
                    break;
                case 4:
                    if (player.getInventory().isFirewood()) {
                        System.out.println("ℹ️ Bu bölgenin ödülünü zaten kazandınız! Tekrar giremezsiniz!");
                        continue;
                    } else {
                        location = new Forest(player);
                    }
                    break;
                case 5:
                    if (player.getInventory().isWater()) {
                        System.out.println("ℹ️ Bu bölgenin ödülünü zaten kazandınız! Tekrar giremezsiniz!");
                        continue;
                    } else {
                        location = new River(player);
                    }
                    break;
                case 6:
                    location = new Maden(player);
                    break;
                default:
                    System.out.println("⚠️ Lütfen geçerli bir bölge giriniz!");
            }

            if (location == null) {
                System.out.println("═════════════════════════════════");
                System.out.println("🏁 Oyun bitti, yine bekleriz ❤️❤️❤️");
                break;
            }
            if (!location.onLocation()) {
                System.out.println("💀 Game over!");
                break;
            }
        }
    }
}
