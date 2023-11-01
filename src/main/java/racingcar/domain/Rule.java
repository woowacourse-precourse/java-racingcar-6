package racingcar.domain;

import racingcar.policy.MovingPolicy;
import racingcar.policy.NumberGeneratePolicy;

public class Rule {

    private final MovingPolicy movingPolicy;
    private final NumberGeneratePolicy numberGeneratePolicy;

    public Rule(MovingPolicy movingPolicy, NumberGeneratePolicy numberGeneratePolicy) {
        this.movingPolicy = movingPolicy;
        this.numberGeneratePolicy = numberGeneratePolicy;
    }

    public boolean canMove() {
        return movingPolicy
                .canMove(numberGeneratePolicy.generate());
    }

}
