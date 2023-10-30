package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final String MOVE_FORWARD_VALUE = "-";
    private static final String STATUS_DELIMITER = " : ";
    private static final Integer MINIMUM_FORWARD_NUMBER = 4;

    private String name;
    private StringBuilder currentStatus;

    public Car(String name) {
        this.name = name;
        this.currentStatus = new StringBuilder();
    }

    public void decideMoveOrNot() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= MINIMUM_FORWARD_NUMBER) {
            currentStatus.append(MOVE_FORWARD_VALUE);
        }
    }

    public String getCurrentStatus() {
        return name + STATUS_DELIMITER + currentStatus.toString();
    }

    public int getScore() {
        return currentStatus.length();
    }

    @Override
    public String toString() {
        return name;
    }
}
