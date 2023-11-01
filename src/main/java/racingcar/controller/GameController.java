package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.car.Cars;
import racingcar.domain.game.Game;
import racingcar.validator.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    public void run() {
        List<String> carNames = inputCarNames();
        int tryNumber = getTryNumber();

        Cars cars = new Cars(carNames);
        Game game = new Game(tryNumber);

        OutputView.informPlayResult();
        performRound(cars, game);
        informFinalWinner(cars);
    }

    private List<String> inputCarNames() {
        String carNames = InputView.askCarNames();
        List<String> carName = splitCarNames(carNames);
        InputValidator.validateCarNameLength(carName);
        return carName;
    }

    private int getTryNumber() {
        String stringNumber = InputView.askTryNumber();
        InputValidator.validateTryNumberType(stringNumber);
        return Integer.parseInt(stringNumber);
    }

    private void informFinalWinner(Cars cars) {
        List<String> winnerCarNames = cars.sortFinalWinner();
        OutputView.informFinalWinner(winnerCarNames);
    }

    private void performRound(Cars cars, Game game) {
        while(game.isPlay()) {
            cars.moveCars();
            game.countPlayNumber();
            OutputView.informCarMoveDistance(cars.getCars());
        }
    }

    private static List<String> splitCarNames(String carNames) {
        return Arrays.stream(carNames.split(",")).toList();
    }
}