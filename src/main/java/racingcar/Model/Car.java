package racingcar.Model;

import static racingcar.Constants.ErrorMessage.EMPTY_NAME;
import static racingcar.Constants.ErrorMessage.NAME_LEN_MAX;

public class Car {
    private String name;

    private int distance = 0;

    public Car(String name) {
        name = name.trim();

        validateEmpty(name);
        validateNameLength(name);

        this.name = name;
    }

    void validateNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(NAME_LEN_MAX.getMessage());
        }
    }

    void validateEmpty(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_NAME.getMessage());
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Car && obj != null) {
            return name.equals(((Car) obj).getName());
        } else {
            return false;
        }
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void incrementDistance() {
        this.distance++;
    }
}
