package racingcar;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.CarList;
import racingcar.domain.TryCount;

public class RacingGame {
    private CarList carList;
    OutputView outputView = new OutputView();
    TryCount tryCount = new TryCount("5");


    public void moveForCount(int tryCount) {
        for(int i = 0; i < tryCount; i++){
            carList.moveAll();
            printCarsStatus();
        }
    }

    public void printCarsStatus() {
        outputView.raceOutput(carList.carsStatus());
    }

    public List<Car> generateCar(String carNames) {
        List<Car> cars = Arrays.stream(carNames.split(","))
                .map(Car::new)
                .toList();
        carList = new CarList(cars);
        return cars;
    }
}
