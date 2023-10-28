package racingcar.domain.car;

import racingcar.domain.car.dto.output.CarRacingDto;
import racingcar.domain.move.MoveCommand;

public final class CarRacing extends Car {

    public CarRacing(final String carName) {
        super(carName);
    }

    public void moveBy(final MoveCommand command) {
        if (MoveCommand.GO == command) {
            coordinate.increase();
        }
    }

    public CarRacingDto toDto() {
        return new CarRacingDto(carName.carName(), coordinate.getCoordinate());
    }
}
