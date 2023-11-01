package racingcar.service;

import racingcar.constant.Rule;

public class Accelerator {

    private final NumberGenerator numberGenerator;

    public Accelerator(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public boolean canMoveForward() {
        return Rule.MOVEMENT_POSSIBILITY <= getMovementPotential();
    }

    private Integer getMovementPotential() {
        return numberGenerator.generate();
    }
}
