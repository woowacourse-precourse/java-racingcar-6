package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int position;
    private static final int MOVE_STANDARD = 4;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void move() {
        int randomNumber = generateRandomNumber();
        if (randomNumber >= MOVE_STANDARD) {
            position++;
        }
    }

    private static int generateRandomNumber() {
        return Randoms.pickNumberInRange(0,9);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
