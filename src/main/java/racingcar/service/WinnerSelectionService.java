package racingcar.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import racingcar.domain.position.Position;
import racingcar.dto.CarStatusDto;

public class WinnerSelectionService {

    public List<CarStatusDto> selectWinners(List<CarStatusDto> carsStatusAtRaceEnd) {
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
