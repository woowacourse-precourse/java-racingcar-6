package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.validator.CarValidator.*;
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

    public static void getCarInput(List<Car> carList){
        String carName = getCarName();
        splitCarList(carList, carName);
        checkAllException(carList);
    }

    public static String getCarName() {
        getCarNameNotification();
        String carNameList = readLine();
        return carNameList;
    }

    public static void splitCarList(List<Car> carList, String carNames) {
        String[] carNameList = carNames.split(DELIMITER);
        for (String carName : carNameList) {
            carList.add(new Car(carName));
        }
    }
}
