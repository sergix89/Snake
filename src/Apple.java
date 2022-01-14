import java.awt.*;

public class Apple extends GameObject {
    public Apple(){
        color = Color.green;
        coordinates[0]=((int)((Math.random()*(Snake.gameField.getWidth()-22)))/22)*22;
        coordinates[1]=((int)((Math.random()*(Snake.gameField.getHeight()-22)))/22)*22;
    }
}
