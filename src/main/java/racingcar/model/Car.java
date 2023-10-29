package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final static int MOVING_STANDARD = 4;

    private final String name;
    private int location = 0;

    public Car(String name) {
        this.name = name;
    }


    public void move(){
        int randomNumber = createRandomNumber();
        if(isMoveFront(randomNumber)){
            location++;
        }
    }

    private int createRandomNumber(){
        return Randoms.pickNumberInRange(0,9);
    }

    private boolean isMoveFront(int randomNumber){
        return randomNumber >= MOVING_STANDARD;
    }

}
