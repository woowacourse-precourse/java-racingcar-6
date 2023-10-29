package racingcar.domain.game.car;

import java.util.ArrayList;
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

    public CarsMovementDto moveOnce(MoveStrategy moveStrategy) {
        List<CarMovementDto> carsMovement = getCarsMovement(moveStrategy);
        return new CarsMovementDto(carsMovement);
    }

    private List<CarMovementDto> getCarsMovement(MoveStrategy moveStrategy) {
        List<CarMovementDto> carsMovementDto = new ArrayList<>();
        for (Car car : cars) {
            if (moveStrategy.isMovable()) {
                car.moveOnce();
            }
            carsMovementDto.add(car.toCarMovementDto());
        }
        return carsMovementDto;
    }

    public WinnersDto toWinnerDto() {
        int maxPosition = getMaxPosition();
        String winners = getWinners(maxPosition);
        return new WinnersDto(winners);
    }

    private String getWinners(int maxPosition) {
        return cars.stream()
                .filter(car -> car.isSameAs(maxPosition))
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
