package racingcar.vo;

import racingcar.util.validation.TryNumberValidator;

public record TryNumber(Integer number) {

    public TryNumber {
        TryNumberValidator.validateTryNumber(number);
    }
}
