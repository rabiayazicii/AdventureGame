package com.adventuregame.locations;

import com.adventuregame.entities.Player;
import com.adventuregame.interfaces.ILocation;

import java.util.Random;
import java.util.Scanner;

/**
 * Abstract Location - SRP principle
 * Sadece temel location işlevlerini içerir
 */
public abstract class Location implements ILocation {
    protected Player player;
    protected String name;
    protected Scanner input = new Scanner(System.in);

    public Location(Player player, String name) {
        this.name = name;
        this.player = player;
    }

    @Override
    public abstract boolean onLocation();

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Player getPlayer() {
        return player;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
