package racingcar.controller;

import java.util.List;
import racingcar.Validator;
import racingcar.controller.dto.RoundResponseDto;
import racingcar.domain.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    GameService gameService = new GameService();
    Validator validator = new Validator();

    public void run() {
        OutputView.printStartGame();
        String[] input = InputView.inputCarList();
        List<Car> carList = gameService.registerCarListFromInput(input);
        int gameRound = validator.validateGameRound(InputView.inputGameRound());

        OutputView.printRoundStart();
        for (int i = 0; i < gameRound; i++) {
            // 1개 라운드
            for (Car tempCar : carList) {
                tempCar.move();
            }
            // 게임 결과 출력
            OutputView.printGameStatus(new RoundResponseDto(carList));
        }

        List<Car> winnerCars = gameService.extractWinner(carList);

        String gameWinner = gameService.getGameWinner(winnerCars);
        OutputView.printGameWinner(gameWinner);

    }

}

