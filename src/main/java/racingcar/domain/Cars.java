package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getWinners() {
        Position maxPosition = calculateMaxPosition();

        ArrayList<Car> winnerCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition().equals(maxPosition)) {
                winnerCars.add(car);
            }
        }

        return winnerCars;
    }

    public void driveOneRound(int pivotNumber) {
        for (Car car : cars) {
            int number = Randoms.pickNumberInRange(0, 9);
            if(number >= pivotNumber) {
                car.moveForward();
            }
        }
    }

    private Position calculateMaxPosition() {
        Position maxPosition = new Position();

        for (Car car : cars) {
            if (car.getPosition().isGreaterThen(maxPosition)) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
