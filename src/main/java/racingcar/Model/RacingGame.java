package racingcar.Model;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.Model.Car;
import racingcar.View.RacingGameView;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private final List<Car> cars;
    private final int totalRounds;

    public RacingGame(List<String> carNames, int totalRounds) {
        validateNumberOfRounds(totalRounds);
        this.cars = carNames.stream().map(Car::new).collect(Collectors.toList());
        this.totalRounds = totalRounds;
    }

    private void validateNumberOfRounds(int numberOfRounds) {
        if (numberOfRounds <= 0) {
            throw new IllegalArgumentException();
        }
    }

    public void start(RacingGameView view) {
        for (int round = 0; round < totalRounds; round++) {
            playRound();
            view.printRoundResult(cars, round);
        }
        view.printWinners(getWinners());
    }

    private void playRound() {
        for (Car car : cars) {
            int randomValue = Randoms.pickNumberInRange(0, 9);
            car.move(randomValue);
        }
    }

    public List<String> getWinners() {
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}