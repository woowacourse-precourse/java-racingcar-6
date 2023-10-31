package racingcar.model;

import racingcar.util.GameUtil;

public class Car {

    private final String carName;
    private int position;
    private int MOVE_NUM = 4;
    public Car(String name){
        carName = name;
        position = 0;
    }

    public void move(int randomNumber){
        if (randomNumber >= MOVE_NUM){
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
