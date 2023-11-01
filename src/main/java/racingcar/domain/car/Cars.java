package racingcar.domain.car;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import racingcar.domain.position.Position;
import racingcar.dto.CarStatusDto;
import racingcar.dto.RoundResultDto;

public class Cars {

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars createFrom(List<Car> cars) {
        return new Cars(cars);
    }

    public void tryDriveAll() {
        cars.forEach(Car::tryDrive);
    }

    private Position getFurthestPosition() {
        return cars.stream()
                .map(Car::getPosition)
                .max(Position::compareTo)
                .orElseThrow(NoSuchElementException::new);
    }

    public List<CarStatusDto> getWinners() {
        Position furthestPosition = getFurthestPosition();
        return cars.stream()
                .filter(car -> car.getPosition().equals(furthestPosition))
                .map(CarStatusDto::createFrom)
                .collect(Collectors.toList());
    }

    public RoundResultDto getCurrentRoundSnapshot() {
        List<CarStatusDto> snapshot = cars.stream()
                .map(CarStatusDto::createFrom)
                .toList();
        return new RoundResultDto(snapshot);
    }


}
