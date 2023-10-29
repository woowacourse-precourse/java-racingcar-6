package racingcar.controller;

import static racingcar.constant.ViewMessage.INSERT_CARS_NAMES;
import static racingcar.constant.ViewMessage.INSERT_MOVING_COUNT;

import racingcar.model.CarsPosition;
import racingcar.model.MovingCount;
import racingcar.model.RacingCars;
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
        CarsPosition carsPosition = CarsPosition.createPositionWithRacingCars(racingCars);

        for (int i = 0; movingCount.isNotEqual(i); i++) {
            OutputView.printlnResult(carsPosition.getEachRaceResult());
        }
        OutputView.printlnResult(carsPosition.getWinner());
    }
}
