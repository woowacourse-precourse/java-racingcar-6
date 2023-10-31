package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.dto.MoveResultDto;

public class Car {

    private static final int START_LOCATION = 0;
    private static final int MOVE_FORWARD_NUMBER = 4;
    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;

    private final CarName name;
    private Integer location;

    private Car(CarName name) {
        this.name = name;
        this.location = START_LOCATION;
    }

    protected static Car createWithName(CarName name) {
        return new Car(name);
    }

    protected MoveResultDto getResultDto() {
        moveOrStop(generateRandomNumber());
        return MoveResultDto.create(name.getCarName(), location);
    }

    protected void moveOrStop(int randomNumber) {
        if (randomNumber >= MOVE_FORWARD_NUMBER) {
            moveForward();
        }
    }

    protected int generateRandomNumber() {
        return Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
    }

    private void moveForward() {
        location++;
    }

    protected String getName() {
        return name.getCarName();
    }

    protected Integer getLocation() {
        return location;
    }
}
