package racingcar.model.vehicle;

import racingcar.model.rule.GameRuleValidator;

public record Name(String name) {
    public Name {
        GameRuleValidator.validateName(name);
    }
}
