package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Name;
import racingcar.domain.car.RacingCar;
import racingcar.domain.car.RacingCarWinners;
import racingcar.domain.car.RacingCars;

class GameRankingsTest {

    private final GameRankings gameRankings = new GameRankings();
    private final GameRound gameRound = new GameRound("1");
    RacingCars racingCars;

    @BeforeEach
    void setUp() {
        List<RacingCar> racingCarList = List.of(new RacingCar("one"), new RacingCar("two"), new RacingCar("three"));

        racingCars = new RacingCars(racingCarList);
    }

    @Test
    void RacingCar들의_move_결과를_저장한다() {
        // given
        RacingCars relocatedRacingCars = racingCars.move(() -> true);

        // when
        gameRankings.saveEachRoundResult(gameRound, relocatedRacingCars);
        Map<GameRound, RacingCars> gameRankingsMap = gameRankings.getGameRankings();

        // then
        RacingCars gameRankings = gameRankingsMap.get(gameRound);
        gameRankings.forEach(racingCar -> assertEquals(1, racingCar.getPosition()));
    }

    @Test
    void move_결과를_통해_우승자들을_찾는다() {
        // given
        RacingCars relocatedRacingCars = racingCars.move(() -> true);

        // when
        RacingCarWinners winners = relocatedRacingCars.findWinners();

        // then
        assertTrue(winners.contains(new Name("one")));
        assertTrue(winners.contains(new Name("two")));
        assertTrue(winners.contains(new Name("three")));
    }
}