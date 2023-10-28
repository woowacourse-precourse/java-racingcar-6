package racingcar.domain;

import racingcar.application.NumberGenerator;

public class Navigator {
    private final NumberGenerator numberGenerator;

    public Navigator(final NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public MoveAction decideMoveAction() {
        int number = numberGenerator.generateNumber();
        return MoveAction.of(number);
    }
}
