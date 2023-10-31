package racingcar.domain.car;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.dto.CarMovementDto;
import racingcar.domain.dto.CarsMovementDto;
import racingcar.domain.dto.WinnersDto;
import racingcar.move.MoveStrategy;
import racingcar.util.Err;

public class Cars {
    private static final String WINNER_NAME_DELIMITER = ", ";
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(List<Car> cars) {
        return new Cars(cars);
    }

    public void moveOnceIfMovable(MoveStrategy moveStrategy) {
        for (Car car : cars) {
            if (moveStrategy.isMovable()) {
                car.moveOnce();
            }
        }
    }

    public CarsMovementDto toCarsMovementDto() {
        List<CarMovementDto> carsMovementDto = cars.stream()
                .map(Car::toCarMovementDto)
                .toList();
        return new CarsMovementDto(carsMovementDto);
    }

    public WinnersDto toWinnerDto() {
        String winners = findWinners();
        return new WinnersDto(winners);
    }

    private String findWinners() {
        return cars.stream()
                .filter(car -> car.isSameAs(findCarWithMaxPosition()))
                .map(Car::getCarName)
                .collect(Collectors.joining(WINNER_NAME_DELIMITER));
    }

    private Car findCarWithMaxPosition() {
        return cars.stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new IllegalArgumentException(Err.EMPTY_CAR_LIST.getMessage()));
    }
}
