package racingcar.controller;

import racingcar.exception.BusinessException;
import racingcar.exception.ExceptionCode;
import racingcar.service.RaceService;
import racingcar.view.dto.CarNameList;
import racingcar.service.dto.TotalGameResult;
import racingcar.model.Model;
import racingcar.model.ModelConst;
import racingcar.view.RaceView;

public class RaceController {

    private final RaceService raceService;
    private final RaceView raceView;
    private final Model model;

    public RaceController(final RaceService raceService, final RaceView raceView, final Model model) {
        this.raceService = raceService;
        this.raceView = raceView;
        this.model = model;
    }

    public void run() {
        CarNameList carNames = getCarNameList();
        String attemptNumber = getAttemptNumber();

        TotalGameResult gameResult = raceService.doRace(carNames, attemptNumber);
        model.setAttribute(ModelConst.TOTAL_GAME_RESULT, gameResult);
        raceView.printResult();
    }

    private CarNameList getCarNameList() {
        raceView.conveyCarNames();
        return (CarNameList) model.getAttribute(
                ModelConst.CAR_NAME
        )
                .orElseThrow(() -> new BusinessException(
                        ExceptionCode.NO_CAR_LIST,
                        this.getClass()
                ));
    }

    private String getAttemptNumber() {
        raceView.conveyAttemptNumber();
        return (String) model.getAttribute(
                ModelConst.ATTEMPT_NUMBER
        )
                .orElseThrow(() -> new BusinessException(
                        ExceptionCode.NO_RESULT,
                        this.getClass()
                ));
    }
}
