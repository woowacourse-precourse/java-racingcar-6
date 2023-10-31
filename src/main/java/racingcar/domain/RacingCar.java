package racingcar.domain;

import java.util.Objects;
import racingcar.domain.condition.MoveCondition;

public class RacingCar {
    private final String carName;
    private final MoveCondition moveCondition;

    public RacingCar(String carName, MoveCondition moveCondition) {
        if (carName.length() <= 5) {
            this.carName = carName;
            this.moveCondition = moveCondition;
            return;
        }
        throw new IllegalArgumentException("자동차 이름은 5글자 이하로만 입력할 수 있습니다.");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RacingCar racingCar = (RacingCar) o;
        return Objects.equals(carName, racingCar.carName) && Objects.equals(moveCondition,
                racingCar.moveCondition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, moveCondition);
    }
}

