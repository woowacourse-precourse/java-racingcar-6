package racingcar.vo;

import racingcar.exception.business.CarNameValidator;

public record CarName(String name) {

    public CarName {
        CarNameValidator.validateCarName(name);
    }
}
