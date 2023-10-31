package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MOVE_CONDITION = 4;
    private final String name;
    private int position = 0;

    public Car(String name) {
        if (name == null || name.trim().isEmpty() || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 1~5자 이내만 가능합니다.");
        }
        this.name = name;
    }

    public void move() {
        if (makeRandomNumber() >= MOVE_CONDITION) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private int makeRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
