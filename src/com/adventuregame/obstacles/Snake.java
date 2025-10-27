package com.adventuregame.obstacles;

import com.adventuregame.entities.Obstacle;
import java.util.Random;

/**
 * Snake obstacle - SRP principle
 * Sadece Snake engelinin özelliklerini içerir
 */
public class Snake extends Obstacle {
    public Snake() {
        super(4, new Random().nextInt(4) + 3, "Yılan", 12, 0); // damage rastgele 3-6 arası olacak
    }
}
