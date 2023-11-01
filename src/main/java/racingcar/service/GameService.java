package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.view.GameOutputView;

public class GameService {
    private final List<Car> cars = new ArrayList<>();

    public GameService() {
    }

    public void start(List<String> carNames, int tryCount) {
        setCars(carNames);
        for (int i = 0; i < tryCount; i++) {
            moveEachCar();
            GameOutputView.printRacingProcess(cars);
            System.out.println();
        }
    }

    private void moveEachCar() {
        cars.forEach(Car::move);
    }

    private void setCars(List<String> carNames) {
        carNames.forEach(carName ->
                cars.add(new Car(carName))
        );
    }

}
