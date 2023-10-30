package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int RANDOM_MIN = 0;
    private static final int RANDOM_MAX = 10;
    private static final int MOVE_VALUE = 4;

    private String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void cycle() {
        if (createRandomNumber() >= MOVE_VALUE) {
            movePosition();
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private int createRandomNumber() {
        int randomNumber = Randoms.pickNumberInRange(RANDOM_MIN, RANDOM_MAX);
        return randomNumber;
    }

    private void movePosition() {
        position++;
    }

}
