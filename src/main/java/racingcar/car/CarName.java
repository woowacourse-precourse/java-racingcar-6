package racingcar.car;

import racingcar.util.Validator;

public record CarName(String name) {
    public CarName {
        Validator validator = new Validator();
        validator.validateCarName(name);
    }
}
