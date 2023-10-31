package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int MIN = 0;
    private static final int MAX = 9;
    private static final int NAME_LENGTH = 5;
    private static final String INVALID_LENGTH = "자동차 이름의 길이는 5자 이하여야합니다.";

    private final String name;
    private int position;

    public Car(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name.isBlank() || name.length() == 0 || NAME_LENGTH < name.length()) {
            throw new IllegalArgumentException(INVALID_LENGTH);
        }
    }

    public void move() {
        if (canGo()) {
            position++;
        }
    }

    private boolean canGo() {
        int number = Randoms.pickNumberInRange(MIN, MAX);
        return 4 <= number;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
