package racingcar;

import java.util.ArrayList;
import java.util.List;

import static racingcar.CommandLine.showln;

public class CarList {
    private final List<Car> cars;

    public CarList(List<Car> cars) {
        this.cars = cars;
    }

    public void playRound(
            MoveForwardConditioner moveForwardConditioner
    ) {
        for (Car car : this.cars) {
            if (moveForwardConditioner.canMoveForward()) {
                car.moveForward();
            }
        }
        for (Car car : this.cars) {
            car.showCurrentMoveForward();
            showln("");
        }
        showln("");
    }

    public String winningCars() {
        int maxCount = this.cars.get(0).getMoveForwardCount();
        for (Car car : this.cars) {
            maxCount = getMaxCount(car, maxCount);
        }
        return carsMatchWithMaxCount(maxCount);
    }

    private int getMaxCount(Car car, int maxCount) {
        if (maxCount < car.getMoveForwardCount()) {
            maxCount = car.getMoveForwardCount();
        }
        return maxCount;
    }

    private String carsMatchWithMaxCount(int maxCount) {
        List<String> winnerCarNameList = new ArrayList<>();
        for (Car car : this.cars) {
            findWinningCars(car, maxCount, winnerCarNameList);
        }
        return String.join(", ", winnerCarNameList);
    }

    private void findWinningCars(
            Car car,
            int maxCount,
            List<String> winnerCarNameList
    ) {
        if (car.getMoveForwardCount() == maxCount) {
            winnerCarNameList.add(car.getName());
        }
    }
}
