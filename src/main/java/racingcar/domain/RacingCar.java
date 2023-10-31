package racingcar.domain;

import static racingcar.exception.ErrorMessage.CAR_NAME_LENGTH_OVER_FIVE_EXCEPTION;

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
        throw new IllegalArgumentException(CAR_NAME_LENGTH_OVER_FIVE_EXCEPTION);
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

