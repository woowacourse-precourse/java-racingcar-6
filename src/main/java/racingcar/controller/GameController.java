package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    GameService gameService = new GameService();
    public void run() {
        OutputView.printStartGame();
        String[] input = InputView.inputCarList();
        List<Car> carList = gameService.registerCarListFromInput(input);
    }

}
