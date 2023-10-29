package racingcar.controller;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

import static racingcar.view.InputView.*;
import static racingcar.view.OutputView.*;

public class RacingController {

    private static final String DELIMITER = ",";
    private static final int MINIMUM_MOVE_CONDITION = 4;

    public static void start() {
        List<Car> carList = new ArrayList<>();
        getCarInput(carList);
        int tryCount = getTryCount();
        for (int i = 0; i < tryCount; ++i) {
            moveOrNot(carList);
            printResult(carList);
        }
        printWinnerList(carList);
    }
}
