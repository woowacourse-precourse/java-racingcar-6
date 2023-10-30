package racingcar.console.game.racingcar.core;

import racingcar.console.game.racingcar.car.Car;

import java.util.ArrayList;
import java.util.List;

public class GameManager {

    private final PlayerInputValidator validator;
    private final GameConfig gameConfig;

    private final List<Car> cars;
    private final List<Car> winners;

    public GameManager() {
        validator = new PlayerInputValidator();
        gameConfig = new GameConfig();

        cars = new ArrayList<>();
        winners = new ArrayList<>();
    }

    public void registerCarList(String carListString) {
        validator.carListValidate(carListString);
        addCarList(carListString);
    }

    private void addCarList(String carList) {
        List<String> nameList = List.of(carList.split(","));

        for (String name : nameList) {
            cars.add(new Car(name));
        }
    }

    public void setTotalRound(String totalRoundString) {
        validator.totalRoundValidate(totalRoundString);
        gameConfig.setTotalRound(totalRoundString);
    }

    public void startRace() {
        for (int i = 0; i < gameConfig.getTotalRound(); i++) {
            operateAllCars();
            indicateAllCars();
            System.out.println();
        }
    }

    private void operateAllCars() {
        for (Car car : cars) {
            car.operate();
        }
    }

    private void indicateAllCars() {
        for (Car car : cars) {
            car.indicateLocation();
        }
    }

    public void calculateWinners() {
        int maxDistance = findMaxDistance();
        findWinners(maxDistance);
    }

    private int findMaxDistance() {
        int max = Integer.MIN_VALUE;
        for (Car car : cars) {
            if (car.getLocation() > max) {
                max = car.getLocation();
            }
        }
        return max;
    }

    private void findWinners(int max) {
        for (Car car : cars) {
            if (car.getLocation() == max) {
                winners.add(car);
            }
        }
    }

    public String getWinners() {
        String[] winnerNames = winners.stream()
                .map(Car::getName)
                .toArray(String[]::new);

        return String.join(", ", winnerNames);
    }

}
