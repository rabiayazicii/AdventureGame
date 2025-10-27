package com.adventuregame.interfaces;

/**
 * Weapon interface - ISP principle
 * Sadece silah özelliklerini içerir
 */
public interface IWeapon extends IItem {
    int getDamage();
}
