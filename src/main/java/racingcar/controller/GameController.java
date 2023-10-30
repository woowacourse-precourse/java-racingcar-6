package racingcar.controller;

import java.util.List;
import racingcar.manager.Validator;
import racingcar.controller.dto.RoundResponseDto;
import racingcar.domain.Car;
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
        int gameRound = validator.validateGameRound(InputView.inputGameRound());
        OutputView.printRoundStart();
        runRound(gameRound, carList);

        List<Car> winnerCars = gameService.extractWinner(carList);

        String gameWinner = gameService.getGameWinner(winnerCars);
        OutputView.printGameWinner(gameWinner);

    }

    private void runRound(int gameRound, List<Car> carList) {
        for (int i = 0; i < gameRound; i++) {
            for (Car tempCar : carList) {
                tempCar.move();
            }
            OutputView.printGameStatus(new RoundResponseDto(carList));
        }
    }

}

