package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public void move() {
        int randomNumber = getRandomNumber();
        if (randomNumber >= 4) {
            this.position++;
        }
    }
}
