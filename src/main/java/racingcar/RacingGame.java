package racingcar;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.CarList;
import racingcar.domain.TryCount;

public class RacingGame {
    private final OutputView outputView = new OutputView();
    private CarList carList;

    public void printWinners() {
        outputView.winnerOutput(carList.getWinnerNames());
    }

    public void moveForCount(int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            carList.moveAllCars();
            printCarsStatus();
        }
    }

    public void printCarsStatus() {
        outputView.raceOutput(carList.getCarsStatus());
    }

    public List<Car> generateCar(String carNames) {
        List<Car> cars = Arrays.stream(carNames.split(","))
                .map(Car::new)
                .toList();
        carList = new CarList(cars);
        return cars;
    }
}
