package racingcar.domain.car;

import racingcar.domain.position.Position;
import racingcar.domain.power.Power;
import racingcar.domain.power.PowerGenerator;

public class Car {

    private static final Power POWER_THRESHOLD_FOR_DRIVE = new Power(4);
    private static final int MOVE_WEIGHT = 1;

    private CarName carName;
    private Position position;
    private PowerGenerator powerGenerator;

    public Car(String name, int position, PowerGenerator powerGenerator) {
        this.carName = new CarName(name);
        this.position = new Position(position);
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

    public String getCarName() {
        return carName.getValue();
    }

    public Position getPosition() {
        return position;
    }
}
