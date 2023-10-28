package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int currentPosition;

    public Car(String name) {
        this.name = name;
    }

    private int getRandomNumber(){
        return Randoms.pickNumberInRange(0, 9);
    }


}
