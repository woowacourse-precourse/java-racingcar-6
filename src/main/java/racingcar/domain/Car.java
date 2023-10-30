package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        if (name == null || name.trim().isEmpty() || name.trim().length() > 5) {
            throw new IllegalArgumentException("자동차 이름 형식이 잘못되었습니다.");
        }
        this.name = name;
    }

    public void move() {
        if (shouldMove()) {
            position++;
        }
    }

    private boolean shouldMove() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
