import javax.swing.*;
import java.awt.*;

public class GameField extends JPanel {
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (!Game.body.isEmpty()){
            for (Segment s: Game.body){
                g.setColor(s.color);
                g.fillRect(s.coordinates[0],s.coordinates[1],20,20);
            }
        }
        g.setColor(Game.apple.color);
        g.fillRect(Game.apple.coordinates[0], Game.apple.coordinates[1],20,20);
        g.setColor(Game.head.color);
        g.fillRect(Game.head.coordinates[0], Game.head.coordinates[1], 20, 20);
    }
}
