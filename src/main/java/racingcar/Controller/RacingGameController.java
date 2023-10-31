package racingcar.Controller;

import racingcar.Model.RacingGameModel;
import racingcar.View.RacingGameView;

import java.util.List;

public class RacingGameController {
    private RacingGameModel model;
    private RacingGameView view;

    public RacingGameController(RacingGameModel model, RacingGameView view) {
        this.model = model;
        this.view = view;
    }

    public void runGame() {
        String nameInputs = view.nameInput();
        String turnInput = view.turnsInput();

        List<String> names = InputConverter.nameInputCvt(nameInputs);
        int turns = InputConverter.turnsInputCnt(turnInput);


    }
}
