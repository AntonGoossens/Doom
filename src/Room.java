public class Room {
    public static final int WIDTH = 10;
    public static final int HEIGHT = 10;
    private Player player;
    private char[][] floorPlan;

    public Room() {
        this.player = new Player(WIDTH / 2, HEIGHT / 2);
        floorPlan = new char[WIDTH][HEIGHT];
        player.setRoom(this);
        createFloorplan();
    }

    private void createFloorplan() {
        floorPlan = new char[HEIGHT][WIDTH];
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                if (i == 0 || i == HEIGHT - 1) floorPlan[i][j] = '-';
                else if (j == 0 || j == WIDTH - 1) floorPlan[i][j] = '|';
                else floorPlan[i][j] = ' ';
            }
        }
    }

    public void draw() {
        for (char[] row : floorPlan) {
            for (char karakter : row) {
                System.out.print(karakter + " ");
            }
            System.out.println();
        }
    }

    public boolean isFree(int x, int y) {
        if (x < floorPlan.length && x >= 0)
            if (y < floorPlan[x].length && y >= 0)
                return floorPlan[x][y] == ' ';
        return false;
    }

    public boolean isFinished() {
        return player.isDeath();
    }

    public void update() {
        floorPlan[player.getX()][player.getY()] = ' ';
        player.move();
        floorPlan[player.getX()][player.getY()] = player.toString().charAt(0);
    }

    public Player getPlayer() {
        return player;
    }
}
