package racingcar.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.dto.CarPositionResponse;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.util.CarFactory;

public class RacingCarGame {

    private static OutputView outputView;

    public RacingCarGame() {
        outputView = new OutputView();
    }

    public void play() {
        Cars cars = CarFactory.generate(InputView.inputCarNames());
        TryCount tryCount = InputView.inputTryCount();
        OutputView.printExecutionResultMessage();

        List<List<CarPositionResponse>> executionResults = new ArrayList<>();

        for (int i = 0; i < tryCount.getTryCount(); i++) {
            cars.move();

            List<CarPositionResponse> executionResult = cars.getCars().stream()
                    .map(CarPositionResponse::create)
                    .collect(Collectors.toList());
            executionResults.add(executionResult);
        }
        outputView.printExecutionResults(executionResults);
        printFinalResult(cars.getCars());
    }

    private void printFinalResult(List<Car> cars) {

        List<String> winnerNames = new ArrayList<>();

        cars = cars.stream()
                .sorted(Comparator.comparing(Car::getPosition).reversed())
                .collect(Collectors.toList());

        int maxMoveCounts = cars.get(0).getPosition();

        for(Car car : cars) {
            if (car.getPosition() == maxMoveCounts) {
                winnerNames.add(car.getName());
                continue;
            }
            break;
        }
        outputView.printFinalResult(winnerNames);
    }
}
