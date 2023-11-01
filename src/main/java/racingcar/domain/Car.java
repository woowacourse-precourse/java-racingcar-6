package racingcar.domain;

import static racingcar.constant.Constants.NAME_MAX_LENGTH;

public class Car {
    private final int id;
    private final String name;
    private final int position;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public Car(int id, String name, int position) {
        validator(name);
        this.id = id;
        this.name = name;
        this.position = position;
    }

    private void validator(String name) {
        validationNamingRule(name);
    }
    private void validationNamingRule(String name) {
        if (name.length() < NAME_MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}
