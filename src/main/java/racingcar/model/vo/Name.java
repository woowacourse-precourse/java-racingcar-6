package racingcar.model.vo;

import racingcar.model.GameRuleValidator;

public record Name(String name) {
    public Name {
        GameRuleValidator.validateName(name);
    }
}
