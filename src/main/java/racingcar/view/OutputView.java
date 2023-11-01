package racingcar.view;

import static racingcar.utils.Message.*;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {
    public void printStartGameMessage() {
        System.out.println(START_GAME_MESSAGE.getMessage());
    }

    public void printAttempNumMessage() {
        System.out.println(ATTEMPT_NUM_MESSAGE.getMessage());
    }

    public void printResultMessage() {
        System.out.println();
        System.out.println(RESULT_MESSAGE.getMessage());
    }

    public void printAttempResult(List<Car> cars) {
        cars.forEach(car -> System.out.println(car.toString()));
        System.out.println();
    }

    public void printWinners(List<Car> winners) {
        System.out.print(WINNER_PRINT_MESSAGE.getMessage());

        List<String> winnerNames = winners.stream().map(Car::getName).toList();
        System.out.println(String.join(", ", winnerNames));
    }

    public String printProgressBar(int progress) {
        String progressBar = PROGRESSBAR_CHAR.getMessage();
        return progressBar.repeat(progress);
    }
}
