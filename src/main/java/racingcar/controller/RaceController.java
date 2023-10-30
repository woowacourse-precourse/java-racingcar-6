package racingcar.controller;

import racingcar.service.RaceService;
import racingcar.domain.CarNameList;
import racingcar.domain.TotalGameResult;
import racingcar.model.Model;
import racingcar.model.ModelConst;
import racingcar.view.RaceView;

public class RaceController {

    private final RaceService raceService;
    private final RaceView raceView;
    private final Model model;

    public RaceController(RaceService raceService, RaceView raceView, Model model) {
        this.raceService = raceService;
        this.raceView = raceView;
        this.model = model;
    }

    public void run() {
        raceView.conveyCarNames();
        raceView.conveyAttemptNumber();
        String attemptNumber = (String) model.getAttribute(ModelConst.ATTEMPT_NUMBER).orElseThrow();
        CarNameList carNames = (CarNameList) model.getAttribute(ModelConst.CAR_NAME).orElseThrow();

        TotalGameResult gameResult = raceService.doGame(carNames, attemptNumber);
        model.setAttribute("total game result", gameResult);
        raceView.printResult();
    }

}
