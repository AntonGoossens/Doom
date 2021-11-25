import static java.lang.Thread.sleep;

public class Doom {
    private Room room;

    public Doom() {
        room = new Room();
    }

    public boolean isFinished() {
        return room.isFinished();
    }

    public void start() {
        while (!(isFinished())) {
            room.update();
            room.draw();

            this.showInfo();

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void showInfo() {
        System.out.println(room.getPlayer().getHealth());
    }
}
