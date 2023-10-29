package racingcar;

import java.util.List;

public class RacingGame {
    List<Car> carList;
    RacingSetting racingSetting;

    void printMovingResult() {
        for (Car currentCar: carList) {
            currentCar.printInformation();
        }
    }
}
