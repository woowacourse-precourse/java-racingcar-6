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

    public void start() {
        setRacingGame();
    }

    private void setRacingGame() {
        String userEnteredApplicantCarList = inputView.enterCarName();
        int userEnteredRaceCount = Integer.parseInt(inputView.enterRaceCount());
        racingGameService.settingForRacingGame(userEnteredApplicantCarList, userEnteredRaceCount);
    }
}
