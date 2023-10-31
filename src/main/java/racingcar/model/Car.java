package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Car {

    public static final int MAX_NAME_LENGTH = 5;

    private final String name;

    private final List<String> position;

    public Car(String name) {
        this.name = name;
        position = new ArrayList<>();
    }


}
