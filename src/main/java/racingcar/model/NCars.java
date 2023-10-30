package racingcar.model;

import java.util.ArrayList;
import java.util.List;


public class NCars {
    private final List<Car> cars;

    public NCars(final List<Car> cars) {
        this.cars = cars;
    }

    public static NCars applyNames(final List<String> names) {
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(Car.applyName(name));
        }
        return new NCars(cars);
    }

    public List<Integer> moveCars() {
        List<Integer> carsPositions = new ArrayList<>();
        for (Car car : this.cars) {
            carsPositions.add(car.changePosition(
                    CarMovementStatus.getMovementStatusByCheckNumber(
                            RandomNumberGenerator.getRandomNUmber())));
        }
        return carsPositions;
    }

    public List<List<Integer>> moveCarsRepeatedByRound(Integer round) {
        List<List<Integer>> carsPositions = new ArrayList<>();
        for (int i = 0; i < round; i++) {
            carsPositions.add(moveCars());
        }
        return carsPositions;
    }

    public List<String> getSingleRoundResult() {
        List<String> resultMessage = new ArrayList<>();
        for (Car car : cars) {
            resultMessage.add(car.getRoundResult().toString());
        }
        return resultMessage;
    }

    public List<String> getNamesForTest() {
        List<String> names = new ArrayList<>();
        for (Car car : this.cars) {
            names.add(car.toString());
        }
        return names;
    }

    public List<String> getWinnerName() {
        List<String> winnerNames = new ArrayList<>();
        List<RoundResult> results = new ArrayList<>();
        for (Car car : cars) {
            results.add(car.getRoundResult());
        }
        Integer maxPosition = results
                .stream()
                .mapToInt(RoundResult::position)
                .max()
                .orElse(0);
        for (Car car : cars) {
            if(car.isWinner(maxPosition)){
                winnerNames.add(car.toString());
            };
        }
        return winnerNames;
    }
}
