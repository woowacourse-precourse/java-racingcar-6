package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int randomNumber;
    private int distance = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void setRandomNumber() {
        this.randomNumber = Randoms.pickNumberInRange(0, 9);
    }

    private void move() {
        if (randomNumber >= 4) {
            this.distance++;
        }
    }

}