package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.view.ResultView;

public class GameService {

    private List<Car> cars = new ArrayList<>();
    private ResultView view = new ResultView();

    public List<Car> getCars() {
        return this.cars;
    }

    private void addRacingCar() {
        for (int i = 0; i < carNames.size(); i++) {
            cars.add(new Car(carNames.get(i)));
        }
    }

    private void startGame() {
        for (int i = 0; i < tryCount; i++) {
            for (Car car : cars) {
                car.tryMoveForward();
            }
        }
    }

    void showGameProgress() {
        for (int i = 1; i <= tryCount; i++) {
            for (Car car : cars) {
                view.printPosition(i, car.getSuccessCount());
            }
            System.out.println("");
        }
    }
}
