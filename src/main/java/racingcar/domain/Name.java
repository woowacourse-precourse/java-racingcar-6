package racingcar.domain;

import racingcar.util.Validator;

public record Name(String value) {

    public Name {
        Validator.validateName(value);
    }
}
