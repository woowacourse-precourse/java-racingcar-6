package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private static final int CAR_MAXIMUM_NUMBER = 10;
    private final List<Car> cars;

    public Cars(List<String> carNameList) {
        cars = new ArrayList<>();
        addCarInCars(carNameList);
    }

    public void playTurn() {
        for (Car car : cars) {
            car.moveRandomly();
            car.printPresentMovingDistance();
        }
    }

    public Winners getWinners() {
        return new Winners(cars);
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
