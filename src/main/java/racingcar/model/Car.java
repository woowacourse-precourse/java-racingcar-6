package racingcar.model;

import java.util.List;
import racingcar.utils.Validator;

public class Car {
    private final List<String> names;
    private final int attempt;

    public Car(List<String> names, int attempt) {
        this.names = names;
        this.attempt = attempt;
    }

}
