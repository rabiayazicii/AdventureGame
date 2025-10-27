package com.adventuregame.interfaces;

/**
 * Item interface - ISP principle
 * Sadece eşya özelliklerini içerir
 */
public interface IItem {
    String getName();
    int getId();
    int getPrice();
}
