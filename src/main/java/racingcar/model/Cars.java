package racingcar.model;

import racingcar.dto.CarDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;
    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void RandomMoveAll() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        for (Car car : this.cars) {
            RandomNumber randomNumber = randomNumberGenerator.generate();
            if (randomNumber.isGreaterThanFour()) {
                car.move();
            }
        }
    }

    public List<Car> findWinner() {

        validateEmpty();

        Car leadCar = findLeadCar();

        return findAllLeadCar(leadCar);
    }

    private void validateEmpty() {
        if (this.cars.isEmpty()) {
            throw new IllegalArgumentException("자동차가 한대도 없습니다.");
        }
    }

    private Car findLeadCar() {
        Car leadCar = this.cars.get(0);
        for (Car car : this.cars) {
            if (car.isFrontOf(leadCar)) {
                leadCar = car;
            }
        }
        return leadCar;
    }

    private List<Car> findAllLeadCar(Car leadCar) {
        List<Car> leadCars = new ArrayList<>();
        for (Car car : this.cars) {
            if (car.isSamePosition(leadCar)) {
                leadCars.add(car);
            }
        }
        return leadCars;
    }

    public List<CarDto> toDtos() {
        return this.cars.stream()
                .map(Car::toDto)
                .collect(Collectors.toList());
    }
}
