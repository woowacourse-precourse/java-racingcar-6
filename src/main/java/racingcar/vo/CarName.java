package racingcar.vo;

import racingcar.util.validation.CarNameValidator;

public record CarName(String name) {

    public CarName {
        CarNameValidator.validateCarName(name);
    }
}
