package racingcar.domain;

import racingcar.Console.Constants;

public class Car {

    private String name;
    private int moveCounts;

    public Car(String name) {
        isValidNameSize(name);
        this.name = name;
        this.moveCounts = 0;
    }

    private void isValidNameSize(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(Constants.EXCEPTION_CAR_NAME_SIZE_MESSAGE);
        }
    }

    void addMoveCounts(boolean isMove) {
        if (isMove) {
            this.moveCounts++;
        }
    }

    int getMoveCounts() {
        return this.moveCounts;
    }

    String getName() {
        return this.name;
    }
}
