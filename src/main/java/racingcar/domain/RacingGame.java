package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import static racingcar.manager.RandomNumberGenerator.generate;
import static racingcar.manager.Validator.validateNoDuplicateNames;

public class RacingGame {
    private final List<Car> cars;
    private final int rounds;

    public RacingGame(String[] carNames, int rounds) {
        validateNoDuplicateNames(carNames);
        this.rounds = rounds;
        this.cars = initializeCars(carNames);
    }

    private List<Car> initializeCars(String[] carNames) {
        List<Car> carsList = new ArrayList<>();
        for (String carName : carNames) {
            carsList.add(new Car(carName.trim()));
        }
        return carsList;
    }

    public List<Car> playRound() {
        for (Car car : cars) {
            car.move(generate());
        }
        return new ArrayList<>(cars);
    }

    public List<String> getWinners() {
        int maxPosition = getMaxPosition();
        return filterCarsByPosition(maxPosition);
    }

    private List<String> filterCarsByPosition(int position) {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == position) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    private int getMaxPosition() {
        int max = 0;
        for (Car car : cars) {
            max = Math.max(max, car.getPosition());
        }
        return max;
    }

    public int getRounds() {
        return rounds;
    }
}
