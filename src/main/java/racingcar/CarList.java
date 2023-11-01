package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class CarList {

    private final List<Car> cars;

    public CarList(List<Car> cars) {
        this.cars = cars;
    }


    public void moveCars() {

        cars.stream().forEach(car -> {
            if (Randoms.pickNumberInRange(Constant.NUMBER_RANGE_INCLUDE, Constant.NUMBER_RANGE_EXCLUDE) >= 4) {
                car.moveForward();
            }
        });
    }


    public List<Car> getCarList() {
        return this.cars;
    }

    private int getMaxPositon() {
        int maxPosition = 0;
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }

    public List<Car> getCarsOnMaxPosition() {
        int maxPositon = getMaxPositon();
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPositon) {
                winners.add(car);
            }
        }
        return winners;
    }
}


