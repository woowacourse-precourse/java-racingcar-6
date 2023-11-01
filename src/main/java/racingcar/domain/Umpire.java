package racingcar.domain;

import static racingcar.constant.GameMessage.DELIMITER_WINNER;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.view.OutputView;

public class Umpire {
    private final List<Car> cars;

    public Umpire(List<Car> cars) {
        this.cars = cars;
    }

    public void showWinner() {
        OutputView.printFinalWinner(findWinner());
    }

    public int findMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    public String findWinner() {
        int maxPosition = findMaxPosition();

        List<String> winners = cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());

        return String.join(DELIMITER_WINNER, winners);
    }
}
