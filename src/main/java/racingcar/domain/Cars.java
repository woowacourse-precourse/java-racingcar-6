package racingcar.domain;

import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private static final int CAR_MAXIMUM_NUMBER = 10;
    List<Car> cars;

    public Cars(List<String> carNameList) {
        cars = new ArrayList<>();
        addCarInCars(carNameList);
    }

    public void playTurn() {
        moveCars();
        printResultOfTurn();
    }

    public Winners getWinners() {
        return new Winners(cars);
    }

    private void printResultOfTurn() {
        for (Car car : cars) {
            car.printPresentMovingDistance();
        }
    }

    private void moveCars() {
        for (Car car : cars) {
            car.moveRandomly();
        }
    }

    private void addCarInCars(List<String> carNameList) {
        for (String carName : carNameList) {
            Car newCar = new Car(carName);
            validateDuplicatedCarName(newCar);
            cars.add(newCar);
            validateCarsMaximumNumber();
        }
    }

    private void validateDuplicatedCarName(Car car) {
        if (cars.contains(car)) {
            throw new IllegalArgumentException("차 이름이 중복되었습니다.");
        }
    }
    private void validateCarsMaximumNumber() {
        if (cars.size() >= CAR_MAXIMUM_NUMBER) {
            throw new IllegalArgumentException(String.format("차의 개수는 %d 을 넘어갈 수 없습니다.", CAR_MAXIMUM_NUMBER));
        }
    }
}
