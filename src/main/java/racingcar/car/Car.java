package racingcar.car;

import static racingcar.system.SystemConstant.*;

import racingcar.assist.RandomNumberGenerator;
import racingcar.system.SystemConstant;

public class Car {

    private final String carName;
    private String position;

    Car(String carName) {
        this.carName = carName;
        this.position = WAIT_LINE_POSITION;
    }

    public void goForward() {
        if (RandomNumberGenerator.generateRandomIntNumberInRange() >= WIN_NUMBER_AT_LEAST){
            position += POSITION_EXPRESSION;
        }
    }

    public CarPositionDto wrapCarPosition() {
        return new CarPositionDto(position);
    }
    public boolean isNameEquals(CarNameDto carNameDto) {
        return carName.equals(carNameDto.getCarName());
    }
}
