package racingcar.controller;

import racingcar.model.MovingCount;
import racingcar.model.RacingCars;
import racingcar.service.RaceService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {
    private RaceController() {
    }

    public static void run() {
        RacingCars racingCars = getRaceCarsFromInput();
        MovingCount movingCount = getMovingCountFromInput();
        InputView.close();
        raceStart(racingCars, movingCount);
    }

    private static RacingCars getRaceCarsFromInput() {
        OutputView.printInsertCarNames();
        return RacingCars.createRacingCars(InputView.readLine());
    }

    private static MovingCount getMovingCountFromInput() {
        OutputView.printInsertMovingCount();
        return MovingCount.createMovingCount(InputView.readLine());
    }

    private static void raceStart(RacingCars racingCars, MovingCount movingCount) {
        RaceService raceService = RaceService.init(racingCars, movingCount);
        OutputView.printGameResultStart();
        OutputView.printResult(raceService.getTotalResult());
        OutputView.printWinner(raceService.getWinner());
    }
}
