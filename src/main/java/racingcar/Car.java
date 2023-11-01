package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.exception.InvalidCarNameException;

public class Car {
    private final String name;
    private int position = 0;

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
        if (isMovable()) {
            position++;
        }
    }

    private boolean isMovable() {
        return Randoms.pickNumberInRange(0, 9) >= 4; // TODO: 상수 분리 방법 고민해보기
    }

    public boolean isPosition(int position) {
        return this.position == position;
    }
}
