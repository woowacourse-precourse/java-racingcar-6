package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;

public class Judge {

    private static class SingletonJudge {
        private static final Judge JUDGE = new Judge();
    }

    public static Judge getInstance() {
        return SingletonJudge.JUDGE;
    }

    private Judge() {
    }

    private void judge(List<Car> carList) {
        Integer winningDistance = 0;
        for (Car car : carList) {
            if (car.getLocation() > winningDistance) {
                winningDistance = car.getLocation();
            }
        }
        for (Car car : carList) {
            if (car.getLocation().equals(winningDistance)) {
                car.setWinner(true);
            }
        }
    }

    public List<Car> getWinningCars(List<Car> carList) {
        judge(carList);
        List<Car> winningCars = new ArrayList<>();
        for (Car car : carList) {
            if (car.isWinner()) {
                winningCars.add(car);
            }
        }
        return winningCars;
    }
}
