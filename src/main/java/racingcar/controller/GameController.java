package racingcar.controller;

import racingcar.domain.gameInfo.InputManager;
import racingcar.service.GameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    public static void racingStart(){
        InputManager inputManager = InputView.startGameInput();
        GameService.racingStart(inputManager);
        OutputView.announceWinner(GameService.chooseWinner());
    }
}
