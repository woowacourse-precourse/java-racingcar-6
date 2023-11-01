package racingcar.service;

import racingcar.model.Car;
import racingcar.util.inputReader;

import java.util.List;

import static racingcar.util.OutputUtils.printReadCarName;
import static racingcar.util.OutputUtils.printReadTryCount;

public class Initializer {

    public static List<Car> initializeCars() {
        printReadCarName();
        return inputReader.readCars();
    }

    public static int initializeTryCount() {
        printReadTryCount();
        return inputReader.readTryCount();
    }
}
