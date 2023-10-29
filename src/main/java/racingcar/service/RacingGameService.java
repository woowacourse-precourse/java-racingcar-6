package racingcar.service;

import java.util.ArrayList;
import java.util.Arrays;
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
    private final Cars cars;
    private final Attempts attempts;
    private final Winners winners;

    public RacingGameService() {
        this.cars = new Cars();
        this.attempts = new Attempts();
        this.winners = new Winners();
    }

    public void addCars(String carNames) {
        List<String> carNameList = new ArrayList<String>(
                Arrays.asList(carNames.split(Constants.SEPARATOR.getStringValue())));
        cars.addCars(carNameList);
    }

    public void setAttempts(String numberOfAttempts) {
        attempts.setNumber(Integer.valueOf(numberOfAttempts));
    }

    public List<Map<MyEnum, String>> getResultList() {
        List<Map<MyEnum, String>> results = new ArrayList<>();
        for (Car car : cars.getCarList()) {
            car.moveForward();
            
            EnumMap<MyEnum, String> result = new EnumMap<>(MyEnum.class);
            
            result.put(MyEnum.CAR_NAME, car.getName());
            result.put(MyEnum.DISTANCE, car.getDistance());
//            Map<String, String> result = new HashMap<>();
//            result.put("carName", car.getName());
//            result.put("distance", car.getDistance());
            results.add(result);
        }
        return results;
    }

    public boolean reaches() {
        for (Car car : cars.getCarList()) {
            if (car.getDistance().length() == attempts.getNumber()) {
                return true;
            }
        }
        return false;
    }

    public void addWinners() {
        for (Car car : cars.getCarList()) {
            if (car.getDistance().length() == attempts.getNumber()) {
                winners.addWinner(car);
            }
        }
    }

    public String getWinnersNames() {
        return winners.getWinner().stream().map(car -> car.getName())
                .collect(Collectors.joining(Constants.SEPARATOR.getStringValue() + " "));
    }
}
