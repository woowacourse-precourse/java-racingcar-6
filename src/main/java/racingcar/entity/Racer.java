package racingcar.entity;

import racingcar.validation.ValidateForm;

public class Racer {
    private static Racer instance;
    private String name;

    private Racer(String name) {
        this.name = name;
    }

    public static Racer getInstance(String name) {
        if (instance == null) {
            instance = new Racer(name);
        }
        return instance;
    }

    public String getName() {
        return this.name;
    }
}
