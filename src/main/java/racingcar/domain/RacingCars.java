package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.dto.CarStatusDto;

public class RacingCars {
    private final List<Car> cars;

    public RacingCars(List<Car> cars) {
        this.cars = cars;
    }

    public void move() {
        cars.forEach(Car::move);
    }

    public RacingResult createRacingResult() {
        List<CarStatusDto> carStatuses = cars.stream()
                .map(car -> new CarStatusDto(car.getName(), car.getPosition()))
                .collect(Collectors.toList());
        return new RacingResult(carStatuses);
    }
}
