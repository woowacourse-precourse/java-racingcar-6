package racingcar.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import racingcar.domain.car.Car;
import racingcar.domain.position.Position;
import racingcar.dto.CarStatusDto;
import racingcar.dto.GameResultDto;
import racingcar.dto.RoundResultDto;

public class RefereeService {

    public GameResultDto publishGameResult(List<RoundResultDto> roundHistories, List<CarStatusDto> cars) {
        return GameResultDto.of(selectWinners(cars), roundHistories);
    }

    public RoundResultDto executeRound(List<Car> cars) {
        cars.forEach(Car::tryDrive);
        return RoundResultDto.createFrom(cars);
    }

    private List<CarStatusDto> selectWinners(List<CarStatusDto> cars) {
        Position furthestPosition = getFurthestPosition(cars);
        return cars.stream()
                .filter(carStatusDto -> carStatusDto.getCarPosition().equals(furthestPosition))
                .collect(Collectors.toList());
    }

    private Position getFurthestPosition(List<CarStatusDto> cars) {
        return cars.stream()
                .map(CarStatusDto::getCarPosition)
                .max(Position::compareTo)
                .orElseThrow(NoSuchElementException::new);
    }
}
