package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int randomNumber;
    private StringBuilder distance = new StringBuilder();

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void race() {
        setRandomNumber();
        move();
    }

    private void setRandomNumber() {
        this.randomNumber = Randoms.pickNumberInRange(0, 9);
    }

    private void move() {
        if (randomNumber >= 4) {
            this.distance.append("-");
        }
    }

}