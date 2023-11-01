package racingcar;

import java.util.List;

public class RacingCarGame {

    private final Cars cars;
    private final int tryNumber;

    public RacingCarGame(Cars cars, int tryNumber) {
        this.cars = cars;
        this.tryNumber = tryNumber;
    }

    public void play() {
        for (int i = 0; i < tryNumber; i++) {
            List<CarStatusDto> carListStatus = cars.moveAllCars();
            GameResultPrinter.printRoundResult(carListStatus);
        }
        GameResultPrinter.printWinners(cars);
    }

}
