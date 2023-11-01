package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    public static final int MAX_NAME_LENGTH = 5;
    public static final int MOVE_CONDITION = 4;

    private final String name;
    private int position = 0;

    private Car(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }

        if (name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 필수입니다.");
        }

        if (name.contains(" ")) {
            throw new IllegalArgumentException("자동차 이름에 공백은 포함할 수 없습니다.");
        }

        this.name = name;
    }

    public static Car of(String name) {
        return new Car(name);
    }

    public void move() {
        if (Randoms.pickNumberInRange(0, 9) >= MOVE_CONDITION) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
