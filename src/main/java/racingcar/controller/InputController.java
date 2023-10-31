package racingcar.controller;

import racingcar.model.Game;
import racingcar.view.InputView;
import racingcar.view.PrintView;

public class InputController {
    private Game game = new Game();

    public InputController(Game game) {
        this.game = game;
    }

    public void inputCarNames() {
        PrintView.inputCarNamesMessage();
        String[] carNames = InputView.inputCarNames();
        for (String name : carNames) {
            game.addCar(name);
        }
    }

    public int inputStageTimes() {
        PrintView.inputStageTimesMessage();
        return InputView.inputStageTimes();
    }
}
