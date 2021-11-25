package version2.doomCharacter;

import version2.Room;

import java.util.Random;

public class Player extends DoomCharacter{
    public static final double START_HEALTH = 9.0;
    private double health;

    public Player(int x, int y) {
        super(x, y);
        this.health = START_HEALTH;
    }

    public void attack(double damage) {
        this.health -= damage;
    }

    public double getHealth() {
        return this.health;
    }

    public boolean isDeath() {
        return this.health <= 0;
    }

    public String toString() {
        return "P";
    }
}
