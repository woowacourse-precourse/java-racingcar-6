package racingcar.domain;

import static racingcar.constant.RacingGameConstant.RACING_CAR_LIMIT_NAME_LENGTH;
import static racingcar.constant.RacingGameConstant.START_POSITION;
import static racingcar.exception.ErrorMessage.CAR_NAME_LENGTH_EXCEPTION;
import static racingcar.exception.ErrorMessage.CAR_POSITION_EXCEPTION;

import java.util.Objects;
import racingcar.domain.condition.MoveCondition;

public class RacingCar {
    private final String carName;
    private final MoveCondition moveCondition;
    private int position;

    public RacingCar(String carName, MoveCondition moveCondition) {
        this(carName, START_POSITION, moveCondition);
    }

    public RacingCar(String carName, int position, MoveCondition moveCondition) {
        validName(carName);
        validPosition(position);
        this.carName = carName;
        this.moveCondition = moveCondition;
        this.position = position;
    }

    private void validName(String carName) {
        if (carName.isEmpty() || carName.isBlank() || carName.length() > RACING_CAR_LIMIT_NAME_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_EXCEPTION);
        }
    }

    private void validPosition(int position) {
        if (position < 0) {
            throw new IllegalArgumentException(CAR_POSITION_EXCEPTION);
        }
    }

    public void race(int randomNumber) {
        if (moveCondition.check(randomNumber)) {
            position++;
        }
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
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

