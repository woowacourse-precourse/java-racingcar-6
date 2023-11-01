package racingcar.model;

import static racingcar.view.messages.ErrorMessages.ERROR_CAR_NAMES_UNIQUE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Cars {
    private static final int INIT_DISTANCE = 0;
    private static final int MIN_RANGE = 0;
    private static final int MAX_RANGE = 9;

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars createCars(List<String> carNames) {
        validateCarNamesUnique(carNames);
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(Car.createCar(carName.trim()));
        }
        return new Cars(cars);
    }

    public void moveAll() {
        for (Car car : cars) {
            int randomNumber = generateRandomNumber();
            car.move(randomNumber);
        }
    }

    public List<String> getWinners() {
        int maxDistance = getMaxDistance();
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (maxDistance == car.getDistance()) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    public int getMaxDistance() {
        int maxDistance = INIT_DISTANCE;
        for (Car car : cars) {
            maxDistance = Math.max(maxDistance, car.getDistance());
        }
        return maxDistance;
    }

    private static void validateCarNamesUnique(List<String> carNames) {
        if (carNames.size() != new HashSet<>(carNames).size()) {
            throw new IllegalArgumentException(ERROR_CAR_NAMES_UNIQUE.getErrorMessage());
        }
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(MIN_RANGE, MAX_RANGE);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car : cars) {
            stringBuilder.append(car.toString())
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
