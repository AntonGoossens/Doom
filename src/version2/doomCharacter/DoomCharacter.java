package version2.doomCharacter;

import version1.Room;

import java.util.Random;

public abstract class DoomCharacter {
    protected int x;
    protected int y;
    protected Random random = new Random();
    private Room room;

    public DoomCharacter(int x, int y) {
        this.x = x;
        this.y = y;
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

    public void move() {
        while (true) {
            //betere kans berekening dan de booleans
            //de booleans was -1 = 50% && 0 = 25% || 1 = 25% (gevolg: gaat naar linkse boven hoek [0,0])
            //nu met de int is het allemaal 33,333...%
            int dxWaarde = random.nextInt(3) - 1;
            int dyWaarde = random.nextInt(3) - 1;
            if (room.isFree(getX() + dxWaarde, getY() + dyWaarde)) {
                this.x += dxWaarde;
                this.y += dyWaarde;
                return;
            }
        }
    }
}
