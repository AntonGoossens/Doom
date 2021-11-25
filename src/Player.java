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
        setRoom();
        health = START_HEALTH;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setRoom() {
        this.room = new Room();
    }
    public Room getRoom(){
        return room;
    }

    public void attack(double damage) {

    }
    public double getHealth(){
        return health;
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
        return health <= 0;
    }

    public String toString() {
        return "P";
    }
}
