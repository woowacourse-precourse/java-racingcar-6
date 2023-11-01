package racingcar.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import racingcar.domain.GameResult;
import racingcar.domain.GameRound;
import racingcar.domain.car.RacingCar;
import racingcar.domain.car.RacingCars;
import racingcar.domain.forwardMethod.RandomForwardMethod;

class GameServiceTest {

    private static final String NAME_SEPARATOR = ",";
    private static final GameService gameService = new GameService();
    private static RacingCars racingCars;

    @BeforeAll
    static void beforeAll() {
        // given
        String input = "one,two,three";
        racingCars = gameService.generateRacingCarName(input);
    }

    @Test
    void 구분자로_구분된_이름으로_RacingCar목록을_만든다() {
        // given

        // when

        // then
        assertTrue(racingCars.contains(new RacingCar("one")));
        assertTrue(racingCars.contains(new RacingCar("two")));
        assertTrue(racingCars.contains(new RacingCar("three")));
        assertFalse(racingCars.contains(new RacingCar("four")));
    }

    @Test
    void race를_진행한_결과를_반환한다() {
        // given

        // when
        GameResult gameResult = gameService.race(racingCars, new GameRound("3"), new RandomForwardMethod());

        // then
        assertThat(gameResult).isNotNull();
    }
}