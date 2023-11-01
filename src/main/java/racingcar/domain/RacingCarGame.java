package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.dto.CarPositionResponse;
import racingcar.dto.WinnersNameResponse;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.util.CarFactory;

public class RacingCarGame {
    private static InputView inputView;
    private static OutputView outputView;

    public RacingCarGame() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void play() {
        Cars cars = CarFactory.generate(inputView.inputCarNames());
        TryCount tryCount = inputView.inputTryCount();
        outputView.printExecutionResultMessage();

        List<List<CarPositionResponse>> executionResults = new ArrayList<>();

        for (int i = 0; i < tryCount.getTryCount(); i++) {
            cars.move();

            List<CarPositionResponse> executionResult = cars.getCars().stream()
                    .map(CarPositionResponse::create)
                    .collect(Collectors.toList());
            executionResults.add(executionResult);
        }
        outputView.printExecutionResults(executionResults);
        printFinalResult(cars);
    }

    private void printFinalResult(Cars cars) {
        List<Car> winnerCars = cars.getWinnerCars();
        outputView.printFinalResult(WinnersNameResponse.create(winnerCars));
    }
}
