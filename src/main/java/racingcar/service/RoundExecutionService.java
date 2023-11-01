package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.RoundCount;
import racingcar.domain.car.Car;
import racingcar.dto.RoundResultDto;

public class RoundExecutionService {
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
}
