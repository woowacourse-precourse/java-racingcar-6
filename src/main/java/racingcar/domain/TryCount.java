package racingcar.domain;

import racingcar.util.Validator;

public record TryCount(int value) {

    public TryCount {
        Validator.checkCount(value);
    }
}
