package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Game {

    private static final int START_POSITION = 0;
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;

    private final List<Car> cars;

    public Game(List<Car> cars) {
        this.cars = cars;
    }

    public void playOnce() {
        cars.forEach(car -> {
            car.moveOrStop(generateRandomNumber());
        });
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }

}
