public class GamePlay implements Runnable {
    void go(){
        while (true) {
            switch (Game.head.moves) {
                case "left" -> Game.left();
                case "right" -> Game.right();
                case "down" -> Game.down();
                case "up" -> Game.up();
                default -> {
                }
            }
            Snake.gameField.repaint();
            Game.delay();
        }
    }

    @Override
    public void run() {
        go();
    }
}