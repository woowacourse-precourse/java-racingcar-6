package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getWinners() {
        Position maxPosition = calculateMaxPosition();
        return calculateWinnerCars(maxPosition);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public void driveOneRoundAllCar(int pivotNumber) {
        cars.forEach(car -> movableCar(pivotNumber, car));
    }

    private List<Car> calculateWinnerCars(Position winnerPosition) {
        return cars.stream()
                .filter(car -> car.isSamePosition(winnerPosition))
                .toList();
    }

    private void movableCar(int pivotNumber, Car car) {
        final int MAX_NUMBER = 9;
        final int MIN_NUMBER = 0;
        int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
        if(randomNumber >= pivotNumber) {
            car.moveForward();
        }
    }

    private Position calculateMaxPosition() {
        List<Position> positionList = cars.stream().map(Car::getPosition).toList();
        return Collections.max(positionList);
    }
}
