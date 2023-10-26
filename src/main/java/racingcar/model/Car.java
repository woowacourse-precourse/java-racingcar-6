package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int currentPosition;
    private static final int SUCCESS_NUMBER = 4;

    public Car(String name) {
        this.name = name;
        this.currentPosition = 0;
    }

    public boolean moveIfRandomSuccess() {
        return createRandomNumber() >= SUCCESS_NUMBER;
    }

    public int createRandomNumber(){
        return Randoms.pickNumberInRange(0,9);
    }
}
