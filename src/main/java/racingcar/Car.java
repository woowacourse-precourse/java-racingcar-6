package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        int randomValue = setRandomNumber();
        if (randomValue >= 4) {
            position++;
        }
    }

    private int setRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

}
