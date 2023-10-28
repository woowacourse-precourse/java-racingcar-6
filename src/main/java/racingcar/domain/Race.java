package racingcar.domain;

import java.util.stream.IntStream;
import javax.swing.Spring;
import racingcar.utils.validation.InputValidation;
import racingcar.view.OutputView;

public class Race {
    private Cars cars;
    private int moveCount;

    public Race(String carNames, String count) {
        this.cars = new Cars(carNames);
        this.moveCount = convertStringToInt(count);
        InputValidation.validateCountRange(moveCount);
    }

    private int convertStringToInt(String count) {
        try {
            return Integer.parseInt(count);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public void printResults() {
        OutputView.printOutputMessage();
        printRaceResult();
        printWinners();
    }

    private void moveCars() {
        cars.move();
        OutputView.printResult(cars.getCars());
    }

    private void printRaceResult() {
        IntStream.range(0, moveCount).forEach(i -> moveCars());
    }

    private void printWinners() {
        OutputView.printWinners(cars.getWinnerNames());
    }
}
