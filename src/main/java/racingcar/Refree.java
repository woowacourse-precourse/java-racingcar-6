package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Refree {
    public boolean verifyPickNumber(int number) {
        if (number >= 4) {
            return true;
        }
        return false;
    }

    public List<Car> calculateFinalResult(List<Car> cars) {
        return findWinnerCars(cars, findMaxCarForwardingCnt(cars));
    }

    private List<Car> findWinnerCars(List<Car> cars, int maxCarForwardCnt) {
        List<Car> winnerCars = new ArrayList<>();
        for (Car car : cars) {
            if (compareMaxAndCarForwardCnt(maxCarForwardCnt, car)) {
                winnerCars.add(car);
            }
        }
        return cars;
    }

    private boolean compareMaxAndCarForwardCnt(int maxCarForwardCnt, Car car) {
        if (car.getForwardCnt() == maxCarForwardCnt) {
            return true;
        }
        return false;
    }

    private int findMaxCarForwardingCnt(List<Car> cars) {
        int max = 0;
        for (Car car : cars) {
            max = checkMaxForwardCnt(max, car);
        }
        return max;
    }

    private int checkMaxForwardCnt(int max, Car car) {
        if (car.getForwardCnt() > max) {
            max = car.getForwardCnt();
        }
        return max;
    }
}
