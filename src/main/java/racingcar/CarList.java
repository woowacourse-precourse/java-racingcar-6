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
        // 자동차 전진
        for (Car car : this.cars) {
            if (moveForwardConditioner.canMoveForward()) {
                car.moveForward();
            }
        }
        // 자동차 전진 show
        for (Car car : this.cars) {
            car.showCurrentMoveForward();
            showln("");
        }
        showln("");
    }

    public String winningCars() {
        int maxCount = this.cars.get(0).getMoveForwardCount();
        // car를 넣어서 value(전진횟수) 구하기, value(전진 횟수) 가장 많은 것을 구하기
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
