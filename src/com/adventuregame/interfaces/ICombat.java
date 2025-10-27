package com.adventuregame.interfaces;

import com.adventuregame.entities.Player;

/**
 * Combat interface - ISP principle
 * Sadece savaş ile ilgili işlevleri içerir
 */
public interface ICombat {
    boolean combat(int obstacleCount);
    int whoFirst();
    void afterHit();
    void playerStats();
    void obstacleStats(int obstacleNumber);
}
