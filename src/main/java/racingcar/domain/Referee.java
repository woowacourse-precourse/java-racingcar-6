package racingcar.domain;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import racingcar.domain.car.Car;
import racingcar.domain.position.Position;
import racingcar.dto.GameResultDto;

public class Referee {

    public GameResultDto publishGameResult(List<Car> cars) {
        return new GameResultDto(selectWinners(cars));
    }

    public void executeRound(List<Car> cars) {
        cars.forEach(Car::tryDrive);
    }

    private List<Car> selectWinners(List<Car> cars) {
        Position furthestPosition = getFurthestPosition(cars);
        return cars.stream()
                .filter(car -> car.getPosition().equals(furthestPosition))
                .collect(Collectors.toList());
    }

    private Position getFurthestPosition(List<Car> cars) {
        return cars.stream()
                .map(Car::getPosition)
                .max(Position::compareTo)
                .orElseThrow(NoSuchElementException::new);
    }
}
