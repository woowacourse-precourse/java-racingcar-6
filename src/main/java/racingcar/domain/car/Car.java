package racingcar.domain.car;

import racingcar.domain.position.Position;
import racingcar.domain.power.Power;
import racingcar.domain.power.PowerGenerator;

public class Car {

    private static final Power POWER_THRESHOLD_FOR_DRIVE = new Power(4);
    private static final int MOVE_WEIGHT = 1;

    private final CarName carName;
    private final Position position;
    private final PowerGenerator powerGenerator;

    public Car(CarName carName, Position position, PowerGenerator powerGenerator) {
        this.carName = carName;
        this.position = position;
        this.powerGenerator = powerGenerator;
    }

    public void tryDrive() {
        Power generatedPower = powerGenerator.generate();
        if (generatedPower.isSufficientToDrive(POWER_THRESHOLD_FOR_DRIVE)) {
            drive();
        }
    }

    private void drive() {
        position.move(MOVE_WEIGHT);
    }

    public CarName getCarName() {
        return carName;
    }

    public Position getPosition() {
        return position;
    }
}
