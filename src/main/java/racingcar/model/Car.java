package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private static final int NAME_MIN_LENGTH = 1;
    private static final int NAME_MAX_LENGTH = 5;
    private String name;

    private List<String> currentLocation;

    public Car(String name) {
        validateNameLength(name);
        this.name = name;
        this.currentLocation = new ArrayList<>();
    }

    public void validateNameLength(String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
        if (name.length() < NAME_MIN_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

}
