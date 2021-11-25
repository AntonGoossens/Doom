package version2.doomCharacter;

public class Monster extends DoomCharacter {
    public static final int STRENGTH = 1;
    private Player player;

    public Monster(Player player, int x, int y) {
        super(x, y);
        this.player = player;
    }

    protected Player getPlayer() {
        return player;
    }

    public String toString() {
        return "M";
    }

    public void attackPlayer() {
        if (Math.abs(this.getX() - player.getX()) <= 1)
            if (Math.abs(this.getY() - player.getY()) <= 1)
                player.attack(STRENGTH);
    }
}
