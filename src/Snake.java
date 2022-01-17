import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Snake implements KeyListener {
    static JFrame frame = new JFrame("Snake");
    static GameField gameField = new GameField();
    static Snake snake = new Snake();
    Thread gamePlayThread = new Thread(new gamePlaynig());

    public static void main(String[] args) {
        snake.start();
    }

    public void start(){
        frame.addKeyListener(this);
        frame.setSize(506,500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(gameField);
        frame.setVisible(true);
        Game.addSegment();
        gamePlayThread.start();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_RIGHT:
                if (!Game.head.moves.equals("left")) {
                    //Game.right();
                    Game.head.moves = "right";
                }
                break;
            case KeyEvent.VK_LEFT:
                if (!Game.head.moves.equals("right")) {
                    //Game.left();
                    Game.head.moves = "left";
                }
                break;
            case KeyEvent.VK_UP:
                if (!Game.head.moves.equals("down")) {
                    //Game.up();
                    Game.head.moves = "up";
                }
                break;
            case KeyEvent.VK_DOWN:
                if (!Game.head.moves.equals("up")) {
                    //Game.down();
                    Game.head.moves = "down";
                }
                break;
            default:
        }
    }

    private class gamePlaynig implements Runnable {
        @Override
        public void run() {
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
    }
}