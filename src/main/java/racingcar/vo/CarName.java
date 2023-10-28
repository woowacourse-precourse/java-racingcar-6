package racingcar.vo;

import racingcar.exception.CarNameValidator;

public record CarName(String name) {

    public CarName {
        CarNameValidator.validateCarName(name);
    }
}
