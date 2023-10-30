package racingcar.controller;

import racingcar.domain.InputManager;
import racingcar.view.InputView;

public class GameController {
    public static void racingStart(){
        InputManager inputManager = InputView.startGameInput();
    }
}
