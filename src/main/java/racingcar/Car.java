package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int MOVE_THRESHOLD = 4;
    private final String name;
    private int position = 0;

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
        if (Randoms.pickNumberInRange(0, 9) >= MOVE_THRESHOLD) {
            position++;
        }
    }
}