package version1;

import java.util.Random;

public class Player {
    public static final double START_HEALTH = 9.0;
    private double health;
    private int x;
    private int y;
    private Random random = new Random();
    private Room room;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
        this.health = START_HEALTH;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void attack(double damage) {
        this.health -= damage;
    }

    public double getHealth() {
        return this.health;
    }

    public void move() {
        while (true) {
            //betere kans berekening dan de booleans
            //de booleans was -1 = 50% && 0 = 25% || 1 = 25% (gevolg: gaat naar linkse boven hoek [0,0])
            //nu met de int is het allemaal 33,333...%
            int dxWaarde = random.nextInt(3)-1;
            int dyWaarde = random.nextInt(3)-1;
            if (room.isFree(getX() + dxWaarde, getY() + dyWaarde)) {
                this.x += dxWaarde;
                this.y += dyWaarde;
                return;
            }
        }
    }

    public boolean isDeath() {
        return this.health <= 0;
    }

    public String toString() {
        return "P";
    }
}
