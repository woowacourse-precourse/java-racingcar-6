package racingcar.vo;

import racingcar.exception.TryNumberValidator;

public record TryNumber(Integer number) {

    public TryNumber {
        TryNumberValidator.validateTryNumber(number);
    }
}
