package racingcar.domain;

import static racingcar.exception.ErrorMessage.CAR_NAME_LENGTH_OVER_FIVE_EXCEPTION;

import java.util.Objects;
import racingcar.domain.condition.MoveCondition;

public class RacingCar {
    private final String carName;
    private final MoveCondition moveCondition;
    private int position;

    public RacingCar(String carName, MoveCondition moveCondition) {
        this(carName, 0, moveCondition);
    }

    public RacingCar(String carName, int position, MoveCondition moveCondition) {
        if (carName.length() <= 5) {
            this.carName = carName;
            this.moveCondition = moveCondition;
            this.position = position;
            return;
        }
        throw new IllegalArgumentException(CAR_NAME_LENGTH_OVER_FIVE_EXCEPTION);
    }

    public void race(int randomNumber) {
        if (moveCondition.check(randomNumber)) {
            position++;
        }
    }

    public String carName() {
        return carName;
    }

    public int position() {
        return position;
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
        return position == racingCar.position && Objects.equals(carName, racingCar.carName)
                && Objects.equals(moveCondition, racingCar.moveCondition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, moveCondition, position);
    }
}

