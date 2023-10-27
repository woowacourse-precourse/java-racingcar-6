package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Map;

public class Car {
    private final String name;
    protected int position;

    public Car(final String name) {
        validateName(name);
        this.name = name;
        this.position = 0;
    }

    private void validateName(String name) {
        if (name == null) {
            throw new IllegalArgumentException();
        }

        String trimmedName = name.trim();

        if (trimmedName.isEmpty() || trimmedName.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    public void move() {
        if (Randoms.pickNumberInRange(0, 9) > 4) {
            position++;
        }
    }

    public String getNameWithPosition() {
        String positionString = "-".repeat(position);
        return name + " : " + positionString;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
