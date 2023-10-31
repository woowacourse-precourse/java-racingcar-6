package racingcar.vo;

import racingcar.validation.business.TryNumberValidator;

public record TryNumber(Integer number) {

    public TryNumber {
        TryNumberValidator.validateTryNumber(number);
    }
}
