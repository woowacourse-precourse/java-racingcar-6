package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String carName;
    private int position = 0;


    public Car(String carName){
        this.carName = carName;
    }

    public void move() {
        if(isMove()){
            position++;
        }
    }
    private boolean isMove(){
        return generateRandomNumber() >= 4;
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

}
