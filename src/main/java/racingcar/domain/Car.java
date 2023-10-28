package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private String name;
    private int position;

    public Car(String name) {
        validationNameLength(name);
        this.name = name;
    }

    private void validationNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 5자 이하여야 합니다.");
        }
    }

    public void move() {
        int value = Randoms.pickNumberInRange(0, 9);
        if (value <= 4) {
            position++;
        }
    }

    public String forwardStatus() {
        return String.format("%s : ", name) + "-".repeat(Math.max(0, position));
    }

    public boolean isSamePosition(int maxPosition) {
        return position >= maxPosition;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
