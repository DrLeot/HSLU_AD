package ch.hslu.ad.Balls;

import java.util.Random;

public class Ball extends Circle implements Runnable{

    public static final int MIN_DIAMETER = 20;
    public static final int MAX_DIAMETER = 50;

    private static Random random = new Random();
    public static final String[] colourList = new String[]{
            "red", "black", "blue",
            "yellow", "green", "magenta" };

    @Override
    public void run() {

        Circle circle = new Circle(Ball.randomRangeInteger(MIN_DIAMETER,MAX_DIAMETER),
                randomRangeInteger(0,BallDemo.WIDTH),randomRangeInteger(0,BallDemo.HEIGHT),
                randomColourString());

        circle.makeVisible();
        circle.slowMoveVertical(randomRangeInteger(100,200));

        if(circle.getY() >= BallDemo.HEIGHT){
            circle.makeInvisible();
        }
    }

    public static int randomRangeInteger(int min, int max){
        if(random == null){
            random = new Random();
        }

        return random.nextInt(min+max)+min;
    }

    public static String randomColourString(){
        return colourList[randomRangeInteger(0,colourList.length)];
    }
}
