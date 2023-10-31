package racingcar.car;

import static racingcar.system.SystemConstant.*;

import racingcar.system.SystemConstant;

public class Car {

    private String carName;
    private String position;

    Car(String carName) {
        this.carName = carName;
        this.position = WAIT_LINE_POSITION;
    }

    public void goForward() {
        position += POSITION_EXPRESSION;
    }

    public CarPositionDto wrapCarPosition() {
        return new CarPositionDto(position);
    }
    public boolean isNameEquals(CarNameDto carNameDto) {
        return carName.equals(carNameDto.getCarName());
    }
}
