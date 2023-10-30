package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.manager.Validator;
import racingcar.sevice.GameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    Validator validator = new Validator();
    GameService gameService = new GameService(validator);

    public void run() {
        OutputView.printStartGame();
        String[] input = InputView.inputCarList();
        List<Car> carList = gameService.registerCarListFromInput(input);
        OutputView.printAskGameRound();
        int gameRound = gameService.getGameRound();
        OutputView.printRoundStart();
        gameService.runRound(gameRound, carList);

        List<Car> winnerCars = gameService.extractWinner(carList);

        String gameWinner = gameService.getGameWinner(winnerCars);
        OutputView.printGameWinner(gameWinner);

    }

}

