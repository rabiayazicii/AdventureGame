package com.adventuregame.interfaces;

/**
 * Character interface - ISP principle
 * Sadece karakter özelliklerini içerir
 */
public interface ICharacter {
    int getId();
    String getName();
    int getDamage();
    int getHealth();
    int getMoney();
}
