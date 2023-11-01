package racingcar.domain.race;

import racingcar.domain.car.Cars;
import racingcar.domain.policy.MoveRule;

public class Race {
    private final MoveRule moveRule;

    public Race(MoveRule moveRule) {
        this.moveRule = moveRule;
    }

    public void run(Cars cars) {
        cars.move(moveRule);
    }
}