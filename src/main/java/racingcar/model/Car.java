package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int MIN_NUMBER_FOR_MOVE = 4;
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (isMovable(randomNumber)) {
            position++;
        }
    }

    private boolean isMovable(int randomNumber) {
        return randomNumber >= MIN_NUMBER_FOR_MOVE;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}

