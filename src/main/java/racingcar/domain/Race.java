package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Race {

    private static final int MIN_RANDOM = 0;
    private static final int MAX_RANDOM = 9;
    private static final int ADVANCE_THRESHOLD = 4;

    private final List<Car> cars;
    private final int raceCount;

    public Race(String carNames, int raceCount) {
        this.cars = initializeCars(carNames);
        this.raceCount = raceCount;
    }

    private List<Car> initializeCars(String carNames) {
        String[] names = carNames.split(",");
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        return cars;
    }

    public void start() {
        for (int i = 0; i < raceCount; i++) {
            performSingleRound();
            printRaceProgress();
        }
    }

    protected int generateRandomNumber() {
        return Randoms.pickNumberInRange(MIN_RANDOM, MAX_RANDOM);
    }

    private void performSingleRound() {
        for (Car car : cars) {
            int randomNumber = generateRandomNumber();
            if (randomNumber >= ADVANCE_THRESHOLD) {
                car.advance();
            }
        }
    }

    private void printRaceProgress() {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public List<Car> getCars() {
        return cars;
    }
}

