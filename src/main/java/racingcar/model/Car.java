package racingcar.model;

import racingcar.util.GameUtil;

public class Car {

    private final String carName;
    private int position;
    private int YOU_CAN_GO = 4;
    public Car(String name){
        carName = name;
        position = 0;
    }

    public void move(){
        if (GameUtil.getRandomNumber() >= YOU_CAN_GO){
            position ++;
        }
    }

    public String getCarName(){
        return carName;
    }

    public int getCarPosition(){
        return position;
    }
}
