package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int randomNumber;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void setRandomNumber() {
        this.randomNumber = Randoms.pickNumberInRange(0, 9);
    }

}