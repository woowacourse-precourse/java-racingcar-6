package racingcar.controller;

import racingcar.model.MovingCount;
import racingcar.model.RacingCars;
import racingcar.service.RaceService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {

    private RaceController() {
    }

    public static void start() {
        OutputView.printInsertCarNames();
        RacingCars racingCars = RacingCars.createRacingCars(InputView.readLine());

        OutputView.printInsertMovingCount();
        MovingCount movingCount = MovingCount.createMovingCount(InputView.readLine());
        InputView.close();

        RaceService raceService = RaceService.init(racingCars, movingCount);
        OutputView.printResult(raceService.getRaceResult());
        OutputView.printWinner(raceService.getWinner());
    }
}
