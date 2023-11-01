package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.dto.RaceResultDTO;

public class Car {

    private static final int START_LOCATION = 0;
    private static final int MOVE_FORWARD_NUMBER = 4;
    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;

    private final String carName;
    private Integer carLocation;

    private Car(String carName) {
        this.carName = carName;
        this.carLocation = START_LOCATION;
    }

    protected static Car createWithName(String name) {
        return new Car(name);
    }

    protected RaceResultDTO move() {
        moveOrStop(generateRandomNumber());
        return RaceResultDTO.create(carName, carLocation);
    }

    protected void moveOrStop(int randomNumber) {
        if (randomNumber >= MOVE_FORWARD_NUMBER) {
            carLocation++;
        }
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
    }

    protected String getName() {
        return carName;
    }

    protected Integer getLocation() {
        return carLocation;
    }
}
