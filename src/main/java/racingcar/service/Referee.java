package racingcar.service;

import racingcar.enums.CarType;
import racingcar.enums.GameSettingType;
import racingcar.model.Attempts;
import racingcar.model.Car;
import racingcar.model.Cars;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Referee {
    private final Attempts attempts;
    private final Cars cars;

    public Referee(Map<GameSettingType, String> info) {
        this.cars = new Cars(info.get(GameSettingType.CAR_NAMES));
        this.attempts = new Attempts(info.get(GameSettingType.ATTEMPTS));
    }

    public boolean anyCarReaches() {
        for (Car car : cars.getCarList()) {
            if (isReached(car)) {
                return true;
            }
        }
        return false;
    }

    public List<Map<CarType, String>> getPlayResults() {
        cars.everyCarMoveForward();

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

    private boolean isReached(Car car) {
        return car.getDistance().length() == attempts.getNumber();
    }
}
