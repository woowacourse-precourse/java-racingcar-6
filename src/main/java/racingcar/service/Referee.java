package racingcar.service;

import racingcar.enums.CarType;
import racingcar.model.Attempts;
import racingcar.model.Car;
import racingcar.model.Cars;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Referee {
    private Attempts attempts;
    private Cars cars;

    public void addCars(String carNames) {
        cars = new Cars(carNames);
    }

    public void setAttempts(String attempts) {
        this.attempts = new Attempts(attempts);
    }

    public boolean anyCarReaches() {
        for (Car car : cars.getCarList()) {
            if (isReached(car)) {
                return true;
            }
        }
        return false;
    }

    public List<Map<CarType, String>> getResults() {
        cars.everyCarMoveForward(); // 모든 차가 전진한다.

        List<Map<CarType, String>> results = new ArrayList<>();
        for (Car car : cars.getCarList()) {
            Map<CarType, String> result = new EnumMap<>(CarType.class);
            result.put(CarType.CAR_NAME, car.getName());
            result.put(CarType.DISTANCE, car.getDistance());
            results.add(result);
        }
        return results;
    }

    public List<String> getWinnersNames() {
        List<String> winnerNames = new ArrayList<>();
        for (Car car : cars.getCarList()) {
            if (isReached(car)) {
                winnerNames.add(car.getName());
            }
        }
        return winnerNames;
    }

    public boolean isReached(Car car) {
        return car.getDistance().length() == attempts.getNumber();
    }
}
