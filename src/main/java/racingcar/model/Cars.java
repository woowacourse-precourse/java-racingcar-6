package racingcar.model;

import racingcar.dto.CarDto;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;
    public Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public void moveUsingRandomNumber(NumberGenerator numberGenerator, MovingStrategy movingStrategy) {
        this.cars.stream()
                .forEach(car -> car.moveUsingRandomNumber(numberGenerator, movingStrategy));
    }

    public List<Car> findWinner() {

        Car leadCar = findLeadCar();

        return findAllLeadCar(leadCar);
    }

    private Car findLeadCar() {
        return this.cars.stream()
                .reduce(this::compareCars)
                .orElseThrow(() -> new IllegalArgumentException("[Error] 자동차가 한대도 없습니다."));
    }

    private List<Car> findAllLeadCar(Car leadCar) {
        return this.cars.stream()
                .filter(car -> car.isSamePosition(leadCar))
                .collect(Collectors.toList());
    }

    private Car compareCars(Car leadCar, Car currentCar) {
        if (currentCar.isFrontOf(leadCar)) {
            return currentCar;
        }
        return leadCar;
    }

    public List<CarDto> toDtos() {
        return this.cars.stream()
                .map(Car::toDto)
                .collect(Collectors.toList());
    }

}
