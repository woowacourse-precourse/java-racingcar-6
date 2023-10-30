package racingcar.domain.car;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.validateRaceCars(cars);
        this.cars = cars;
    }

    public static Cars createFromNames(List<String> names) {
        List<Car> cars = new ArrayList<>();
        names.forEach(name -> cars.add(new Car(name)));

        return new Cars(cars);
    }

    private void validateRaceCars(List<Car> cars) {
        this.validateIsEmpty(cars);
        this.validateIsNull(cars);
    }

    private void validateIsNull(List<Car> cars) {
        cars.forEach(car -> {
            if (car == null) {
                throw new IllegalArgumentException("Car는 null일 수 없습니다.");
            }
        });
    }

    private void validateIsEmpty(List<Car> cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException("빈 배열일 수 없습니다.");
        }
    }

    public void race() {
        cars.forEach(car -> {
            int number = this.getRandomNumber();
            car.tryToMove(number);
        });
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(1, 9);
    }

    public String getStatus() {
        StringBuilder status = new StringBuilder();
        cars.forEach(car -> status.append(car.toString()));
        return status.toString();
    }

    public List<String> findTopCars() {
        Car topPositionCar = this.findTopPositionCar();
        return cars.stream()
                .filter(topPositionCar::isSamePosition)
                .map(Car::getName)
                .toList();
    }

    private Car findTopPositionCar() {
        return cars.stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("Car 리스트가 비어있음."));
    }
}
