package racingcar.domain.driver;

import camp.nextstep.edu.missionutils.Randoms;

public class Driver {

    private final Car car;

    public Driver(Car car) {
        this.car = car;
    }

    public String commandMovement() {
        car.moveForward(Randoms.pickNumberInRange(0, 9));
        generateMovementResultMessage();
        return generateMovementResultMessage();
    }

    private String generateMovementResultMessage() {
        return car.getName() + " : " + "-".repeat(Math.max(0, car.getMovementCount()));
    }
}
