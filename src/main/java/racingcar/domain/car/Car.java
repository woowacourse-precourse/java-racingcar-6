package racingcar.domain.car;

import racingcar.domain.car.carcomponent.carposition.CarPosition;
import racingcar.domain.car.carcomponent.carposition.CarPositionCompareResult;

public class Car {
    private static final String CAR_NAME_ERROR_MESSAGE = "자동차의 이름은 5자 이하만 가능합니다.";
    private static final String MOVE_RESULT_DELIMITER_FOR_CAR = " : ";
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final int START_POSITION = 0;

    private final String carName;
    private CarPosition carPosition;

    public Car(String carName) {
        validateCarName(carName);
        this.carName = carName;
        this.carPosition = new CarPosition(START_POSITION);
    }

    protected void move(boolean moveOrNot) {
        if (moveOrNot) {
            carPosition = carPosition.move();
        }
    }

    protected CarPositionCompareResult comparePosition(Car otherCar) {
        return carPosition.compare(otherCar.carPosition);
    }

    protected String getCarName() {
        return carName;
    }

    protected String makeMoveResultMessage() {
        return carName
                + MOVE_RESULT_DELIMITER_FOR_CAR
                + carPosition.makePositionResultMessage();
    }

    private void validateCarName(String carName) {
        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_ERROR_MESSAGE);
        }
    }
}
