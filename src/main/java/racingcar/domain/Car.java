package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int START_INCLUSIVE = 0;
    private static final int END_INCLUSIVE = 9;
    private static final int MOVE_FORWARD_CONDITION = 4;
    private static final int MOVE_FORWARD_DISTANCE = 1;
    private final String name;
    private int position = 0;

    public Car(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public int getPosition(){
        return position;
    }

    public void moveForward(){
        if(MOVE_FORWARD_CONDITION <= getRandomNumber()){
            this.position += MOVE_FORWARD_DISTANCE;
        }
    }

    private int getRandomNumber(){
        return Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
    }

}
