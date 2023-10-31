package racingcar;

import racingcar.domain.Position;
import racingcar.domain.Race;
import racingcar.domain.Winners;

import java.util.List;

import static racingcar.domain.Position.updatePositions;
import static racingcar.domain.Race.createRaceFromInput;
import static racingcar.domain.Winners.createWinners;

public class Application {
    public static void main(String[] args) {
        Race race = createRaceFromInput();
        List<Position> racingGames = updatePositions(race);
        Winners winners = createWinners(racingGames, race.tryValue());
        winners.printWinners();
    }
}
