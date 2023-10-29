package racingcar.controller;

import static racingcar.constant.ViewMessage.INSERT_CARS_NAMES;
import static racingcar.constant.ViewMessage.INSERT_MOVING_COUNT;

import racingcar.model.MovingCount;
import racingcar.model.RacingCars;
import racingcar.service.RaceService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {

    private RaceController() {
    }

    public static void start() {
        OutputView.printlnViewMessage(INSERT_CARS_NAMES);
        RacingCars racingCars = RacingCars.createRacingCars(InputView.readLine());

        OutputView.printlnViewMessage(INSERT_MOVING_COUNT);
        MovingCount movingCount = MovingCount.createMovingCount(InputView.readLine());
        InputView.close();

        RaceService raceService = RaceService.init(racingCars, movingCount);
        OutputView.printResult(raceService.getRaceResult());
        OutputView.printWinner(raceService.getWinner());
    }
}
