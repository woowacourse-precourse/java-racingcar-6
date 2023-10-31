package racingcar.model;

import racingcar.validator.Validator;

public record TryCount(long tryCount) {
    public TryCount {
        Validator.validateIsPositive(tryCount);
    }
}