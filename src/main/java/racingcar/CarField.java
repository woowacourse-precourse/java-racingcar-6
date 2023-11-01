package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class CarField {
    private static final StringConverter stringConverter = new StringConverter();

    CarField() {
        OutputView.printInitCars();
        List<String> carNames = stringConverter.stringToCarNames(",");

        cars = carNames.stream()
                .map(Car::attendCar)
                .collect(Collectors.toUnmodifiableList());

        OutputView.printRoundSet();
        round = stringConverter.stringToInteger();
    }

    private int round;
    private final List<Car> cars;

    public void run() {
        OutputView.gameStartPrint();
        while (round-- > 0) {
            cars.stream()
                    .forEach(Car::roundStart);

            cars.stream()
                    .forEach(OutputView::printCarField);
            OutputView.newLinePrint();
        }

        OutputView.winnersPrint(whoIsWinner());
    }

    private List<String> whoIsWinner() {
        int winnerScore = maxScore();

        List<String> winners = cars.stream()
                .filter((Car car) -> winnerScore == car.nowScore())
                .map(Car::myName)
                .collect(Collectors.toUnmodifiableList());

        return winners;
    }

    private int maxScore() {
        int winnerScore = cars.stream()
                .mapToInt(Car::nowScore)
                .max()
                .orElseThrow();

        return winnerScore;
    }


}
