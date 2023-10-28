package racingcar.controller;

import static racingcar.controller.InputValidator.*;

import racingcar.model.RacingModel;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    private final InputView inputView;
    private final OutputView outputView;
    private RacingModel racingModel;

    public RacingController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void startRacing() {

        racingSetting();

    }

    private void racingSetting() { // 플레이어들의 이름과 횟수를 설정하는 함수

        outputView.printStarting();
        String[] players = nameValidation(inputView.inputPlayers());
        outputView.printTimes();
        int number = numberValidation(inputView.inputTimes());
        outputView.printRacing(racingModel);

        racingModel = new RacingModel(players, number);

    }


}
