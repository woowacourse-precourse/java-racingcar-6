package racingcar.domain.car;

import racingcar.domain.random.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cars {

    private final List<Car> cars;
    private final RandomNumberGenerator randomNumberGenerator;

    private Cars(List<Car> cars, RandomNumberGenerator randomNumberGenerator) {
        this.validateRaceCars(cars);
        this.randomNumberGenerator = randomNumberGenerator;
        this.cars = cars;
    }

    public static Cars createBy(List<String> names, RandomNumberGenerator randomNumberGenerator) {
        List<Car> cars = new ArrayList<>();
        names.forEach(name -> cars.add(new Car(name)));

        return new Cars(cars, randomNumberGenerator);
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
            int number = randomNumberGenerator.getRandomNumber();
            car.tryToMove(number);
        });
    }

    public List<CarDto> getStatus() {
        List<CarDto> status = new ArrayList<>();
        cars.forEach(car -> status.add(car.getStatus()));
        return status;
    }

    public List<String> findTopCarNames() {
        Car topCar = this.findTopCar();
        return cars.stream()
                .filter(topCar::isSamePosition)
                .map(Car::getName)
                .toList();
    }

    private Car findTopCar() {
        return cars.stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("Car 리스트가 비어있음."));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars other = (Cars) o;
        return Objects.equals(cars, other.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
