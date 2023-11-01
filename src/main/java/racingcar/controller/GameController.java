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
        Cars cars = createCars();
        Game game = createGame();

        play(cars, game);
        informFinalWinner(cars);
    }

    private Cars createCars() {
        List<String> carNames = inputCarNames();
        return new Cars(carNames);
    }

    private List<String> inputCarNames() {
        String carNames = InputView.askCarNames();
        List<String> carName = splitCarNames(carNames);
        InputValidator.validateCarNameLength(carName);
        return carName;
    }

    private static List<String> splitCarNames(String carNames) {
        return Arrays.stream(carNames.split(",")).toList();
    }

    private Game createGame() {
        int tryNumber = getTryNumber();
        return new Game(tryNumber);
    }

    private int getTryNumber() {
        String stringNumber = InputView.askTryNumber();
        InputValidator.validateTryNumberType(stringNumber);
        return Integer.parseInt(stringNumber);
    }

    private void play(Cars cars, Game game) {
        OutputView.informPlayResult();
        while(game.isPlay()) {
            cars.performRound();
            game.countPlayNumber();
            OutputView.informCarMoveDistance(cars.getCars());
        }
    }

    private void informFinalWinner(Cars cars) {
        List<String> winnerCarNames = cars.sortFinalWinner();
        OutputView.informFinalWinner(winnerCarNames);
    }
}