package racingcar.model;

import java.util.List;
import racingcar.utils.Validator;

public class Car {
    private final List<String> names;

    public Car(List<String> names) {
        Validator.validateCarName(names);
        this.names = names;
    }
}
