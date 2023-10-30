package racingcar.controller;

import racingcar.domain.InputManager;
import racingcar.service.GameService;
import racingcar.view.InputView;

public class GameController {
    public static void racingStart(){
        InputManager inputManager = InputView.startGameInput();
        GameService.racingStart(inputManager);
    }
}
