package com.adventuregame.locations;

import com.adventuregame.entities.Player;
import com.adventuregame.items.Armor;
import com.adventuregame.items.Weapon;

/**
 * ToolStore - SRP principle
 * Sadece mağaza işlevlerini içerir
 */
public class ToolStore extends NormalLoc {
    public ToolStore(Player player) {
        super(player, "Mağaza");
    }

    @Override
    public boolean onLocation() {
        boolean showmenu = true;
        System.out.println("🏪 Mağazaya Hpşgeldiniz !");
        while (showmenu) {
            System.out.println("1 - 🔫 Silahlar");
            System.out.println("2 - 🛡️ Zırhlar");
            System.out.println("3 - ❌ Çıkış Yap");
            System.out.println("Seçiminiz: ");
            int selectCase = input.nextInt();
            while (selectCase < 1 || selectCase > 3) {
                System.out.println("⚠️ Geçersiz değer, lütfen tekrar deneyiniz: ");
                selectCase = input.nextInt();
            }

            switch (selectCase) {
                case 1:
                    printweapons();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("🏁 Bir daha bekleriz! ❤️❤️❤️");
                    showmenu = false;
                    break;
            }
        }
        return true;
    }

    public void printweapons() {
        System.out.println("═════════════════════════════════");
        System.out.println("🔫 Silahlar:");
        for (Weapon w : Weapon.weapons()) {
            System.out.println(w.getId() + " - " + w.getName() + " <Para: " + w.getPrice() + " ₺ | Hasar: " + w.getDamage() + " >");
        }
        System.out.println("0 - ❌ Çıkış Yap");
        System.out.println("═════════════════════════════════");
    }

    public void buyWeapon() {
        System.out.println("🔫 Bir silah seçiniz: ");
        int selectWeaponId = input.nextInt();
        while (selectWeaponId < 0 || selectWeaponId > Weapon.weapons().length) {
            System.out.println("⚠️ Geçersiz bir değer girdiniz! Lütfen tekrar deneyiniz: ");
            selectWeaponId = input.nextInt();
        }

        if (selectWeaponId != 0) {
            Weapon selectedWeapon = Weapon.getWeaponsById(selectWeaponId);
            if (selectedWeapon != null) {
                if (selectedWeapon.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("❌ Yeterli paranız bulunmamaktadır.");
                } else {
                    int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("💰 Kalan paranız: " + this.getPlayer().getMoney() + " ₺");
                    System.out.println("🔄 Önceki silahınız: " + this.getPlayer().getInventory().getWeapon().getName());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                    System.out.println("✅ Yeni silahınız: " + this.getPlayer().getInventory().getWeapon().getName());
                }
            }
        }
    }

    public void printArmor() {
        System.out.println("═════════════════════════════════");
        System.out.println("🛡️ Zırhlar:");
        for (Armor a : Armor.armors()) {
            System.out.println(a.getId() + " - " + a.getName() + " <Para: " + a.getPrice() + " ₺ | Blok: " + a.getBlock() + " > ");
        }
        System.out.println("═════════════════════════════════");
    }

    public void buyArmor() {
        System.out.println("🛡️ Bir zırh seçiniz: ");
        int selectArmorId = input.nextInt();
        while (selectArmorId < 0 || selectArmorId > Weapon.weapons().length) {
            System.out.println("⚠️ Geçersiz bir değer girdiniz. Lütfen kontrol ediniz ve tekrar deneyiniz: ");
            selectArmorId = input.nextInt();
        }

        if (selectArmorId != 0) {
            Armor selectedArmor = Armor.getArmorById(selectArmorId);
            if (selectedArmor != null) {
                if (selectedArmor.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("❌ Yeterli paranız bulunmamaktadır.");
                } else {
                    System.out.println("✅ " + selectedArmor.getName() + " zırhını satın aldınız.");
                    int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("💰 Kalan paranız: " + this.getPlayer().getMoney() + " ₺");
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                    System.out.println("🔄 Yeni zırhınız: " + this.getPlayer().getInventory().getArmor().getName());
                }
            }
        }
    }
}
