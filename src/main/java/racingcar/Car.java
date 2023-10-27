package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final String RESULT_FORMAT = "%s : %s";
    private static final String DISTANCE_MARKER = "-";
    private String name;
    private int moveCount;

    Car(String name) {
        this.name = name;
    }

    public void move() {
        int random = Randoms.pickNumberInRange(0, 9);
        if (random >= 4) {
            moveCount += 1;
        }
    }

    public String getCurrentResult() {
        return String.format(RESULT_FORMAT, name, getDistance());
    }

    public int compareTo(Car otherCar) {
        return Integer.compare(moveCount, otherCar.moveCount);
    }

    private String getDistance() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < moveCount; i++) {
            sb.append(DISTANCE_MARKER);
        }
        return sb.toString();
    }
}
