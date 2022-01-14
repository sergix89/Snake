import java.awt.*;

public class Segment extends GameObject{

    public Segment (GameObject s){
        color=s.color;
        moves=s.moves;
        coordinates[0]=s.coordinates[0];
        coordinates[1]=s.coordinates[1];
    }

    public Segment(){
        color = Color.orange;
        if (Game.body.isEmpty()) {
            switch (Game.head.moves) {
                case "left":
                    moves="left";
                    coordinates[0] = Game.head.coordinates[0] + 22;
                    coordinates[1] = Game.head.coordinates[1];
                    break;
                case "right":
                    moves="right";
                    coordinates[0] = Game.head.coordinates[0] - 22;
                    coordinates[1] = Game.head.coordinates[1];
                    break;
                case "up":
                    moves="up";
                    coordinates[0] = Game.head.coordinates[0];
                    coordinates[1] = Game.head.coordinates[1] + 22;
                    break;
                case "down":
                    moves="down";
                    coordinates[0] = Game.head.coordinates[0];
                    coordinates[1] = Game.head.coordinates[1] - 22;
                    break;
            }
        }else{
            switch (Game.body.get(Game.body.size()-1).moves) {
                case "left":
                    moves="left";
                    coordinates[0] = Game.body.get(Game.body.size() - 1).coordinates[0] + 22;
                    coordinates[1] = Game.body.get(Game.body.size() - 1).coordinates[1];
                    break;
                case"right":
                    moves="right";
                    coordinates[0] = Game.body.get(Game.body.size() - 1).coordinates[0] - 22;
                    coordinates[1] = Game.body.get(Game.body.size() - 1).coordinates[1];
                    break;
                case "up":
                    moves="up";
                    coordinates[0] = Game.body.get(Game.body.size() - 1).coordinates[0];
                    coordinates[1] = Game.body.get(Game.body.size() - 1).coordinates[1] + 22;
                    break;
                case "down":
                    moves="down";
                    coordinates[0] = Game.body.get(Game.body.size() - 1).coordinates[0];
                    coordinates[1] = Game.body.get(Game.body.size() - 1).coordinates[1] - 22;
                    break;
                default:
            }
        }
    }
}
