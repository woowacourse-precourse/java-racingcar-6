package racingcar.service;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import racingcar.constants.Constants;
import racingcar.constants.MyEnum;
import racingcar.model.Attempts;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Winners;

public class RacingGameService {
    private Cars cars;
    private Attempts attempts;
    private Winners winners = new Winners();

    public void addCars(String carNames) {
        cars = new Cars(carNames);
    }

    public void setAttempts(String numberOfAttempts) {
        attempts = new Attempts(numberOfAttempts);
    }

    public void everyCarMoveForward() {
        for (Car car : cars.getCarList()) {
            car.moveForward();
        }
    }

    public List<Map<MyEnum, String>> getResultList() {
        List<Map<MyEnum, String>> results = new ArrayList<>();
        for (Car car : cars.getCarList()) {
            EnumMap<MyEnum, String> result = new EnumMap<>(MyEnum.class);
            result.put(MyEnum.CAR_NAME, car.getName());
            result.put(MyEnum.DISTANCE, car.getDistance());
            results.add(result);
        }
        return results;
    }

    public boolean reaches() {
        for (Car car : cars.getCarList()) {
            if (isReached(car)) {
                return true;
            }
        }
        return false;
    }

    public void addWinners() {
        for (Car car : cars.getCarList()) {
            if (isReached(car)) {
                winners.addWinner(car);
            }
        }
    }

    public boolean isReached(Car car) {
        return car.getDistance().length() == attempts.getNumber();
    }

    public String getWinnersNames() {
        return winners.getWinnersNames();
    }
}
