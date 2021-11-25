public class Test {
    public static void main(String[] args) {
        final int WIDTH = 60;
        final int HEIGHT = 20;
        Player player;
        char[][] floorPlan = new char[HEIGHT][WIDTH];

        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                if(i == 0 || i == HEIGHT-1) floorPlan[i][j] = '-';
                else if (j==0 || j==WIDTH-1) floorPlan[i][j] = '|';
                else floorPlan[i][j] = ' ';
            }
        }
        for (char[] row : floorPlan) {
            for (char karakter : row) {
                System.out.print(karakter + " ");
            }
            System.out.println();
        }
    }

    }


