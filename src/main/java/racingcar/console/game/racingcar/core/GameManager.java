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
        validator.validateCarList(carListString);
        addCarList(carListString);
    }

    private void addCarList(String carList) {
        List<String> nameList = List.of(carList.split(","));

        for (String name : nameList) {
            cars.add(new Car(name));
        }
    }

    public void setTotalRound(String totalRoundString) {
        validator.validateTotalRound(totalRoundString);
        gameConfig.setTotalRound(totalRoundString);
    }

    public void startRace() {
        for (int i = 0; i < gameConfig.getTotalRound(); i++) {
            operateAllCars();
            indicateAllCars();
            printBlankLine();
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

    private void printBlankLine() {
            System.out.println();
    }

    public void calculateWinners() {
        int maxDistance = findMaxDistance();
        findWinners(maxDistance);
    }

    private int findMaxDistance() {
        return cars.stream()
                .map(Car::getLocation)
                .max(Integer::compareTo)
                .orElse(0);
    }

    private void findWinners(int max) {
        for (Car car : cars) {
            if (car.getLocation() == max) {
                winners.add(car);
            }
        }
    }

    public String forwardWinners() {
        String[] winnerNames = winners.stream()
                .map(Car::getName)
                .toArray(String[]::new);

        return String.join(", ", winnerNames);
    }

    public PlayerInputValidator getValidator() {
        return validator;
    }

    public GameConfig getGameConfig() {
        return gameConfig;
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> getWinners() {
        return winners;
    }

}
