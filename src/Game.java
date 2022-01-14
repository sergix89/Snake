import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Game {
    static ArrayList<Segment> body = new ArrayList<>();
    static Head head = new Head();
    static Apple apple;
    static int delay = 300;

    static void play() {

    }

    public static void delay() {
        try {
            Thread.sleep(delay);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void eatChecking(){
        if ((apple.coordinates[0]==head.coordinates[0]) && (apple.coordinates[1]==head.coordinates[1])){
            addSegment();
            if (delay>100){
                delay-=10;
            }
        }
        for (Segment s: body){
            if ((s.coordinates[0]==head.coordinates[0]) && (s.coordinates[1]==head.coordinates[1])){
                body = new ArrayList<>(); // если съели себя, создаем новое тело - начинаем игру сначала
                addSegment();
                delay = 300;
                JOptionPane.showMessageDialog(Snake.frame, "Поражение! Для начала новой игры, нажмите Ok!");
            }
        }
    }

    static void refreshCoordinates(){
        Segment exHead = new Segment(head);
        exHead.color = Color.orange;
        if (!body.isEmpty()) {
            if (body.size()>1){
                Segment s;
                for (int i = body.size()-1; i>0; i--) {
                    s = body.get(i-1);
                    body.set(i, s);
                }
                body.set(0, exHead);
            }else{
                body.set(0, exHead);
            }
        }
    }

    static void addSegment(){
        body.add(new Segment());
        apple = new Apple();
    }

    static void right(){
        refreshCoordinates();
        head.coordinates[0] += 22;
        if (head.coordinates[0]>(((Snake.gameField.getWidth()/22)*22)-2)){
            head.coordinates[0]=0;
        }
        head.moves = "right";
        eatChecking();
    }

    static void left(){
        refreshCoordinates();
        head.coordinates[0] -= 22;
        if (head.coordinates[0]<0){
            head.coordinates[0]=((Snake.gameField.getWidth()/22) *22)-22;
        }
        head.moves = "left";
        eatChecking();
    }

    static void up(){
        refreshCoordinates();
        head.coordinates[1] -= 22;
        if (head.coordinates[1]<0){
            head.coordinates[1]=((Snake.gameField.getHeight()/22) *22)-22;
        }
        head.moves = "up";
        eatChecking();
    }

    static void down(){
        refreshCoordinates();
        head.coordinates[1] += 22;
        if (head.coordinates[1]>((Snake.gameField.getHeight()/22) *22)-22){
            head.coordinates[1]=0;
        }
        head.moves = "down";
        eatChecking();
    }

}