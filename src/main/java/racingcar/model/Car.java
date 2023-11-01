package racingcar.model;

import racingcar.util.Util;

public class Car {
    private final String NAME;
    private int position = 0;
    public static final int CAN_MOVE_NUMBER = 4;
    public static final String COLON = " : ";

    public Car(String name){
        this.NAME = name;
    }
    public void move(){
        if(Util.getRandomNumber() >= CAN_MOVE_NUMBER){
            position++;
        }
    }
    public int getPosition(){
        return position;
    }
    public boolean isWinner(int moveLength){
        return position == moveLength;
    }
    public String getTryResult(){
        return NAME+COLON+Util.dashRepeat(position);
    }
    public String getName(){
        return NAME;
    }

}