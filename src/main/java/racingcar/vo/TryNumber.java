package racingcar.vo;

import racingcar.validation.TryNumberValidator;

public record TryNumber(Integer number) {

    public TryNumber {
        TryNumberValidator.validateTryNumber(number);
    }
}
