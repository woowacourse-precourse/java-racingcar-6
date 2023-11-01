package racingcar;

import racingcar.exception.InvalidCarNameException;

public class Car {
    private final String name;
    private final int position = 0;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name == null || name.isEmpty() || name.length() > 5) {
            throw new InvalidCarNameException();
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        // TODO: 자동차 이동 기능 구현
    }

    public boolean isPosition(int position) {
        return this.position == position;
    }
}
