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

    private List<Car> carList;
    private int gameRound;
    
    public void run() {
        OutputView.printStartGame();
        getUserInput();
        playRound();
        List<Car> winnerCars = gameService.extractWinner(carList);
        String gameWinner = gameService.getGameWinner(winnerCars);
        OutputView.printGameWinner(gameWinner);

    }

    private void playRound() {
        OutputView.printRoundStart();
        gameService.runRound(gameRound, carList);
    }

    private void getUserInput() {
        String[] input = InputView.inputCarList();
        carList = gameService.registerCarListFromInput(input);
        OutputView.printAskGameRound();
        gameRound = gameService.getGameRound();
    }

}

