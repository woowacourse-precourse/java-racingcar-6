package racingcar.domain.car;

import racingcar.domain.power.PowerGenerator;

public class Car {

    private static final int POWER_THRESHOLD_FOR_MOVE = 4;
    private static final int MOVE_DISTANCE = 1;

    private String name;
    private int position;
    private PowerGenerator powerGenerator;

    public Car(String name, int position, PowerGenerator powerGenerator) {
        this.name = name;
        this.position = position;
        this.powerGenerator = powerGenerator;
    }

    public void tryDrive() {
        if (isEnoughPower(powerGenerator.generate())) {
            drive();
        }
    }

    private void drive() {
        position += MOVE_DISTANCE;
    }

    private boolean isEnoughPower(int power) {
        return power >= POWER_THRESHOLD_FOR_MOVE;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
