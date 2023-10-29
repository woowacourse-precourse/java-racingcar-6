package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public record Car(String name, int location) {
    private static final int MIN_NUMBER = 0;
    private static final int START_LOCATION = 0;
    private static final int MAX_NUMBER = 9;
    private static final int MIN_FOR_MOVE = 4;
    private static final int MOVE_UNIT = 1;

    public Car(String name) {
        this(name, START_LOCATION);
    }

    public Car moveForward() {
        int randomNumber = getRandomNumber();
        if (canMove(randomNumber)) {
            return new Car(name, location + MOVE_UNIT);
        }
        return new Car(name, location);
    }

    public int getRandomNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }

    private boolean canMove(int randomNumber) {
        return randomNumber >= MIN_FOR_MOVE;
    }
}
