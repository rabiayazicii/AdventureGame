package com.adventuregame.interfaces;

import com.adventuregame.entities.Player;

/**
 * Location interface - ISP principle
 * Sadece location ile ilgili temel işlevleri içerir
 */
public interface ILocation {
    boolean onLocation();
    String getName();
    Player getPlayer();
}
