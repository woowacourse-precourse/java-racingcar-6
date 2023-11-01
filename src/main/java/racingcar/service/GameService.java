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

        GameOutputView.printCarsName(getWinners());
    }

    private void moveEachCar() {
        cars.forEach(Car::move);
    }

    private void setCars(List<String> carNames) {
        carNames.forEach(carName ->
                cars.add(new Car(carName))
        );
    }

    private List<Car> getWinners() {
        List<Car> winners = new ArrayList<>();
        int maxNum = getMaxNum(cars);

        for (Car car : cars) {
            if (car.getNowNum() == maxNum) {
                winners.add(car);
            }
        }

        return winners;
    }

    private int getMaxNum(List<Car> cars) {
        int maxNum = 0;
        for (Car car : cars) {
            maxNum = Math.max(car.getNowNum(), maxNum);
        }

        return maxNum;
    }

}
