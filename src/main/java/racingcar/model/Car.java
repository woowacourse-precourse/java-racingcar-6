package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private final int MIN_NUMBER = 0;
    private final int MAX_NUMBER = 9;
    private final int MOVE_MIN_NUMBER = 4;

    int position = 0;
    String name;

    public Car(String name) {
        this.name = name;
    }

    public boolean canMove() {
        return generateRandomNumber() >= MOVE_MIN_NUMBER;
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }

    public void move() {
        position++;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
