package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.RoundCount;
import racingcar.domain.car.Cars;
import racingcar.dto.RoundResultDto;

public class RoundExecutionService {

    private void executeRound(Cars cars) {
        cars.tryDriveAll();
    }

    public List<RoundResultDto> executeAllRounds(Cars participants, RoundCount roundCount) {
        List<RoundResultDto> roundHistories = new ArrayList<>();
        while (roundCount.hasNextRound()) {
            executeRound(participants);
            roundHistories.add(participants.getCurrentRoundSnapshot());
            roundCount.consumeRound();
        }
        return roundHistories;
    }
}
