package racingcar.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.util.CarFactory;

public class RacingCarGame {

    private List<Car> cars = new ArrayList<>();

    public void play() {
        this.cars = CarFactory.generate(InputView.inputCarNames());
        TryCount tryCount = InputView.inputTryCount();

        OutputView.printExecutionResultMessage();

        for (int i = 0; i < tryCount.getTryCount(); i++) {
            moveRacingCar();
            printExecutionResult();
        }

        printFinalResult();
    }

    private void moveRacingCar() {
        for (Car car : this.cars) {
            car.tryMove();
        }
    }

    private void printExecutionResult() {
        Map<String, Integer> executionResultMap = cars.stream()
                .collect(Collectors.toMap(Car::getName, Car::getPosition));

        OutputView.printExecutionResult(executionResultMap);
    }

    private void printFinalResult() {

        List<String> winnerNames = new ArrayList<>();

        this.cars = this.cars.stream()
                .sorted(Comparator.comparing(Car::getPosition).reversed())
                .collect(Collectors.toList());

        int maxMoveCounts = this.cars.get(0).getPosition();

        for(Car car : this.cars) {
            if (car.getPosition() == maxMoveCounts) {
                winnerNames.add(car.getName());
                continue;
            }
            break;
        }
        OutputView.printFinalResult(winnerNames);
    }
}
