package racingcar.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import racingcar.model.Attemps;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Winners;
import racingcar.utils.Validator;

public class RacingGameService {
    private final Cars cars;
    private final Attemps attemps;
    private final Winners winners;

    public RacingGameService() {
        this.cars = new Cars();
        this.attemps = new Attemps();
        this.winners = new Winners();
    }

    public void addCars(String carNames) {
        List<String> carNameList = new ArrayList<String>(Arrays.asList(carNames.split(",")));
        cars.addCars(carNameList);
    }

    public void setAttemps(String numberOfAttemps) {
        attemps.setNumber(Integer.valueOf(numberOfAttemps));
    }

    public List<Map<String, String>> getResultList() {
        List<Map<String, String>> results = new ArrayList<>();
        for (Car car : cars.getCarList()) {
            Map<String, String> result = new HashMap<>();
            car.moveForward();
            result.put("carName", car.getName());
            result.put("distance", car.getDistance());
            results.add(result);
        }
        return results;
    }

    public boolean reaches() {
        for (Car car : cars.getCarList()) {
            if (car.getDistance().length() == attemps.getNumber()) {
                return true;
            }
        }
        return false;
    }

    public void addWinners() {
        for (Car car : cars.getCarList()) {
            if (car.getDistance().length() == attemps.getNumber()) {
                winners.addWinner(car);
            }
        }
    }

    public String getWinners() {
        return winners.getWinner().stream().map(car -> car.getName()).collect(Collectors.joining(","));
    }
}
