package racingcar.domain.game.car;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.dto.CarMovementDto;
import racingcar.domain.dto.CarsMovementDto;
import racingcar.domain.dto.WinnersDto;
import racingcar.util.MoveStrategy;

public class Cars {
    private static final int MIN_POSITION = 0;
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
        String winners = getWinners();
        return new WinnersDto(winners);
    }

    private String getWinners() {
        return cars.stream()
                .filter(car -> car.isSameAs(getMaxPosition()))
                .map(Car::getCarName)
                .collect(Collectors.joining(WINNER_NAME_DELIMITER));
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(MIN_POSITION);
    }

}
