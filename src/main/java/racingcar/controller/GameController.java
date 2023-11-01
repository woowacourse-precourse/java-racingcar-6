package racingcar.controller;

import racingcar.domain.Movable;
import racingcar.domain.car.Cars;
import racingcar.domain.gameInfo.InputManager;
import racingcar.service.GameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    public static void racingStart(){
        InputManager inputManager = InputView.startGameInput();
        int gameProgressCount = GameService.racingStart(inputManager);
        OutputView.gameStartMessage();
        oneRoundProgress(gameProgressCount);
        OutputView.announceWinner(GameService.chooseWinner());
    }

    public static void oneRoundProgress(int round){
        for(int i =0; i < round;i++) {
            GameService.progressRound();
            OutputView.oneTurnResult(GameService.transferCarsDTO());
        }
    }
}
