import java.util.Random;

public class Player{
    public static final double START_HEALTH = 9.0;
    private double health;
    private int x;
    private int y;
    private Random random = new Random();
    private Room room;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
        //Als ik een Room maak en bij setRoom() kom zit ik in een oneindige lus.
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
    public Room getRoom(){
        return this.room;
    }

    public void attack(double damage) {

    }
    public double getHealth(){
        return this.health;
    }

    public void move() {
        int dxWaarde;
        int dyWaarde;
        do {
            boolean dxPositief = random.nextBoolean();
            boolean dyPositief = random.nextBoolean();
            if (dxPositief) dxWaarde = -1;
            else dxWaarde = 1;
            if (dyPositief) dyWaarde = 1;
            else dyWaarde = -1;
        }
        while (room.isFree(getX() + dxWaarde, getY() + dyWaarde));
        this.x+=dxWaarde;
        this.y+=dyWaarde;

    }

    public boolean isDeath() {
        return this.health <= 0;
    }

    public String toString() {
        return "P";
    }
}
