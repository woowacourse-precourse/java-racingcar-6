package racingcar.domain.car;

import racingcar.domain.position.Position;
import racingcar.domain.power.Power;
import racingcar.domain.power.PowerGenerator;

public class Car {

    private static final Power POWER_THRESHOLD_FOR_MOVE = new Power(4);
    private static final int MOVE_DISTANCE = 1;

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
        if (generatedPower.isSufficientPowerToMove(POWER_THRESHOLD_FOR_MOVE)) {
            drive();
        }
    }

    private void drive() {
        position.move(MOVE_DISTANCE);
    }

    public String getCarName() {
        return carName.getCarName();
    }

    public Position getPosition() {
        return position;
    }
}
