public class Room{
    public static final int WIDTH = 100;
    public static final int HEIGHT = 50;
    private Player player;
    private char[][] floorPlan;

    public Room() {
        this.player = new Player(WIDTH / 2, HEIGHT / 2);
        floorPlan = new char[WIDTH][HEIGHT];
        createFloorplan();
    }

    private void createFloorplan() {
        final int WIDTH = 60;
        final int HEIGHT = 20;
        char[][] floorPlan = new char[HEIGHT][WIDTH];

        for (int i = 0; i < WIDTH; i++) {
            floorPlan[0][i] = '-';
            floorPlan[HEIGHT - 1][i] = '-';
        }
        for (int i = 0; i < HEIGHT; i++) {
            floorPlan[i][0] = '|';
            floorPlan[i][WIDTH - 1] = '|';
        }
        for (int i = 1; i < HEIGHT - 1; i++) {
            for (int j = 1; j < WIDTH - 1; j++) {
                floorPlan[i][j] = ' ';
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
        return floorPlan[x][y] == ' ';
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
