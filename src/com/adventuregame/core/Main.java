package com.adventuregame.core;

/**
 * Main - SRP principle
 * Sadece uygulamanın başlatılmasını içerir
 */
public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
}
