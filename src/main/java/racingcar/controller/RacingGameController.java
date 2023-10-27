package racingcar.controller;

import racingcar.View.InputView;
import racingcar.View.OutPutView;
import racingcar.model.CarRacingGame;
import racingcar.model.RacingCar;
import racingcar.service.RacingGameService;

import java.util.ArrayList;

public class RacingGameController {
    RacingGameService racingGameService = new RacingGameService();
    InputView inputView = new InputView();
    OutPutView outPutView = new OutPutView();

    public void start() {
        setRacingGame();
    }

    private void setRacingGame() {
        String userEnteredApplicantCarList = inputView.enterCarName();
        racingGameService.settingForRacingGame(userEnteredApplicantCarList);
    }
}
