package racingcar.vo;

import racingcar.validation.CarNameValidator;

public record CarName(String name) {

    public CarName {
        CarNameValidator.validateCarName(name);
    }
}
