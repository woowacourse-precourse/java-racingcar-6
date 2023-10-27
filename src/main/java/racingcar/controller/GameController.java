package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.view.InputManager;

public class GameController {
    public void run() {
        String carNames = getCarNameFromUser();
    }

    private String getCarNameFromUser() {
        InputManager.requestCarName();
        return Console.readLine();
    }
}
