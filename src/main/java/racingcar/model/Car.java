package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car implements Comparable<Car> {
    private final String name;
    private int position;

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
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            position++;
        }
    }

    public String getNameWithPosition() {
        String positionString = "-".repeat(position);
        return name + " : " + positionString;
    }

    public int compareTo(Car other) {
        return this.position - other.position;
    }

    public boolean isSamePosition(Car other) {
        return this.position == other.position;
    }

    public String getName() {
        return name;
    }
}
