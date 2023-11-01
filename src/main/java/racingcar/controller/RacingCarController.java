package racingcar.controller;

import racingcar.dto.output.ResultOfTurnDto;
import racingcar.view.RacingCarView;

public class RacingCarController {
    private final RacingCarView racingCarView;

    public RacingCarController(RacingCarView racingCarView) {
        this.racingCarView = racingCarView;
    }
    private void showAdvancecProgress(ResultOfTurnDto resultOfTurnDto) {
        racingCarView.printRacingCarName(resultOfTurnDto);
        racingCarView.printColon();
        racingCarView.printAdvanceMark(resultOfTurnDto);
    }
}
