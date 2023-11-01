package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int position = 0;
    private static final int MIN_MOVE_RANGE = 1;
    private static final int MAX_MOVE_RANGE = 9;
    private static final int MOVE_THRESHOLD = 4;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        if (isMovable()) {
            position += 1;
        }
        displayPosition();
    }

    private boolean isMovable() {
        return Randoms.pickNumberInRange(MIN_MOVE_RANGE, MAX_MOVE_RANGE) >= MOVE_THRESHOLD;
    }

    private void displayPosition() {
        StringBuilder road = new StringBuilder();
        for (int i = 0; i < position; i++) {
            road.append("-");
        }
        System.out.println(name + " : " + road.toString());
    }
}
