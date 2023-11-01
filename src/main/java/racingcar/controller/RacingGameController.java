package racingcar.controller;

import static racingcar.model.GameCountValidator.validateGameCount;
import static racingcar.utils.Utils.convertStringToList;
import static racingcar.view.InputView.inputCarsName;
import static racingcar.view.InputView.inputGameTryNumber;
import static racingcar.view.OutputView.printGameStartMessage;
import static racingcar.view.OutputView.printOneGameResult;
import static racingcar.view.OutputView.printWinners;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.model.Cars;

public class RacingGameController {
    private int gameCount;
    private Cars cars;

    public void startGame() {
        initializeGame();
        playGame();
        showWinners();
    }

    private void initializeGame() {
        cars = new Cars(makeCarList());
        gameCount = makeGameCount();
    }

    private List<Car> makeCarList() {
        List<String> carNameList = convertStringToList(inputCarsName());
        return carNameList.stream()
                .map(Car::makeCarByName)
                .collect(Collectors.toList());
    }

    private int makeGameCount() {
        String gameTryNumber = inputGameTryNumber();
        validateGameCount(gameTryNumber);
        return Integer.parseInt(gameTryNumber);
    }

    private void playGame() {
        printGameStartMessage();
        for (int i = 0; i < gameCount; i++) {
            cars.playOneGame();
            printOneGameResult(cars);
        }
    }

    private void showWinners() {
        printWinners(cars.getWinner());
    }
}
