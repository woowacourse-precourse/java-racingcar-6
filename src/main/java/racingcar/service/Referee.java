package racingcar.service;

import racingcar.enums.GameSettingType;
import racingcar.model.*;

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
            if (car.getDistance().length() == attempts.getNumber()) {
                return true;
            }
        }
        return false;
    }

    public Cars getCars() {
        return cars;
    }

    public PlayResults getPlayResults() {
        return new PlayResults(this.cars);
    }

    public Winners getWinnersNames() {
        return new Winners(this.cars, this.attempts);
    }
}
