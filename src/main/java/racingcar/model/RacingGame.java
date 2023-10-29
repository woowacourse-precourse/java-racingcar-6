package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final List<Car> cars = new ArrayList<>();

    public RacingGame(List<String> carNames) {
        initCars(carNames);
    }

    private void initCars(List<String> carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public String race() {
        for (Car racingCar : cars) {
            racingCar.move();
        }
        return new CurrentResultMap().getCurrentResultMap(cars);
    }

    public String getWinners(){
        return new WinnerCalculator().getWinners(cars);
    }
}
