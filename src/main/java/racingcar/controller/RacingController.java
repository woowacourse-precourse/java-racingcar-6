package racingcar.controller;

import racingcar.domain.Car;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;


public class RacingController {

    private static final String DELIMITER = ",";
    private static final int MINIMUM_MOVE_CONDITION = 4;

    public static void start() {
        List<Car> carList = new ArrayList<>();
        getCarInput(carList);
        int tryCount = getTryCount();
        for (int i = 0; i < tryCount; ++i) {
            moveOrNot(carList);
            OutputView.printResult(carList);
        }
        OutputView.printWinnerList(carList);
    }
}
