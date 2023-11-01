package racingcar.io;

import racingcar.domain.car.dto.RaceResult;

import java.util.List;

public interface Output {
    void printGameMessage(GameMessage gameMessage);
    void printRaceResult(List<RaceResult> raceResult);
    void printWinner(List<String> winners);
}
