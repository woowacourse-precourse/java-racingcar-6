package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import racingcar.domain.RoundCount;
import racingcar.domain.car.Car;
import racingcar.domain.position.Position;
import racingcar.dto.CarStatusDto;
import racingcar.dto.GameResultDto;
import racingcar.dto.RoundResultDto;

public class RefereeService {

    public GameResultDto publishGameResult(List<RoundResultDto> roundHistories,
                                           List<CarStatusDto> carsStatusAtRaceEnd) {
        List<CarStatusDto> winners = selectWinners(carsStatusAtRaceEnd);
        return GameResultDto.of(winners, roundHistories);
    }

    private RoundResultDto executeRound(List<Car> cars) {
        cars.forEach(Car::tryDrive);
        return RoundResultDto.createFrom(cars);
    }

    public List<RoundResultDto> executeAllRounds(List<Car> participants, RoundCount roundCount) {
        List<RoundResultDto> roundHistories = new ArrayList<>();
        while (roundCount.hasNextRound()) {
            RoundResultDto roundResultDto = executeRound(participants);
            roundHistories.add(roundResultDto);
            roundCount.consumeRound();
        }
        return roundHistories;
    }

    private List<CarStatusDto> selectWinners(List<CarStatusDto> carsStatusAtRaceEnd) {
        Position furthestPosition = getFurthestPosition(carsStatusAtRaceEnd);
        return carsStatusAtRaceEnd.stream()
                .filter(carStatusDto -> carStatusDto.getCarPosition().equals(furthestPosition))
                .collect(Collectors.toList());
    }

    private Position getFurthestPosition(List<CarStatusDto> carsStatusAtRaceEnd) {
        return carsStatusAtRaceEnd.stream()
                .map(CarStatusDto::getCarPosition)
                .max(Position::compareTo)
                .orElseThrow(NoSuchElementException::new);
    }
}
