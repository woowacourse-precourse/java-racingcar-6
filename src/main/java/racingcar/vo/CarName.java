package racingcar.vo;

import racingcar.validation.business.CarNameValidator;

public record CarName(String name) {

    public CarName {
        CarNameValidator.validateCarName(name);
    }
}
