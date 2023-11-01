package racingcar.domain;

import static racingcar.constant.GameMessage.DELIMITER_WINNER;

import java.util.ArrayList;
import java.util.List;
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
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }

        return maxPosition;
    }

    public String findWinner() {
        List<String> winners = new ArrayList<>();
        int maxPosition = findMaxPosition();

        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }

        return String.join(DELIMITER_WINNER, winners);
    }
}
