package racingcar.model;

import racingcar.validator.Validator;

public record Name(String name) {
    public Name {
        Validator.validateAvailableLength(name);
        Validator.validateIsBlank(name);
    }
}