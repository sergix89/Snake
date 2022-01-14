import java.awt.*;

public class Head extends GameObject{
    public Head (){
        color = Color.red;
        coordinates[0] = ((int)(Math.random()*20))*22;
        coordinates[1] = ((int)(Math.random()*20))*22;
    }
}
