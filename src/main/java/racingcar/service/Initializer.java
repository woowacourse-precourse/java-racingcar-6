package racingcar.service;

import racingcar.model.Car;
import racingcar.util.InputReader;

import java.util.List;

import static racingcar.util.OutputUtils.printReadCarName;
import static racingcar.util.OutputUtils.printReadTryCount;

public class Initializer {

    public static List<Car> initializeCars() {
        printReadCarName();
        return InputReader.readCars();
    }

    public static int initializeTryCount() {
        printReadTryCount();
        return InputReader.readTryCount();
    }
}
