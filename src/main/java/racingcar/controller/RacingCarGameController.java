package racingcar.controller;

import racingcar.domain.RacingCars;
import racingcar.views.InputView;
import racingcar.views.OutputView;

public class RacingCarGameController {

    private RacingCars racingCars;
    private Integer movingCount;

    public RacingCarGameController() {
    }

    public void racingCarGameStart() {
        racingCarGameInit();

        racingCarGameRun();

        racingCarGameResult();
    }

    private void racingCarGameInit() {
        racingCarCreate();

        gameTryCountCreate();
    }

    private void racingCarCreate() {
        OutputView.racingCarOpeningComment();

        racingCars = InputView.getRacingCars();
    }

    private void gameTryCountCreate() {
        OutputView.tryCountInputComment();

        movingCount = InputView.getMovingCount();
    }

    private void racingCarGameRun() {
        OutputView.racingCarResultComment();
        
        for (int i = 0; i < movingCount; i++) {
            racingCars.MovingCars();
            racingCars.racingCarResultPrint();
        }
    }

    private void racingCarGameResult() {
        String[] winners = racingCars.getRacingWinners();

        OutputView.racingCarWinnerPrint(winners);
    }
}
