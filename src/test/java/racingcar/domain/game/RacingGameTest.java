package racingcar.domain.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Cars;
import racingcar.domain.mock.MockRandomNumberGenerator;
import racingcar.domain.random.GameRandomNumberGenerator;
import racingcar.domain.random.RandomNumberGenerator;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RacingGameTest {

    private Cars cars;

    @BeforeEach
    void setUp() {
        cars = Cars.createFromNames(List.of("hyuns", "pobi"));
    }

    @DisplayName("레이싱 게임에 정상적인 회수가 주어진 경우 해당 회수만큼 게임을 진행한다.")
    @Test
    public void GiveRounds_WhenRace_ThenPlayAsRounds() {
        // Given
        int round = 2;

        Rounds rounds = new Rounds(round);
        GameRandomNumberGenerator gameRandomNumberGenerator = new GameRandomNumberGenerator();
        RacingGame racingGame = new RacingGame(cars, rounds, gameRandomNumberGenerator);

        // When
        int count = 0;
        while (!racingGame.isEnd()) {
            racingGame.race();
            count += 1;
        }

        // Then
        assertEquals(round, count);
    }

    @DisplayName("레이싱 게임을 진행 후 로그를 기록하고 결과를 반환한다.")
    @Test
    public void GiveRandomNumber_WhenRace_ThenReturnResult() {
        // Given
        int round = 2;

        Rounds rounds = new Rounds(round);
        RandomNumberGenerator randomNumberGenerator = MockRandomNumberGenerator.setNumbers(5, 2, 6, 6);
        RacingGame racingGame = new RacingGame(cars, rounds, randomNumberGenerator);

        // When
        while (!racingGame.isEnd()) {
            racingGame.race();
        }
        GameResultDto result = racingGame.getResult();

        // Then
        assertAll(
                () -> assertEquals(1, result.winners().size()),
                () -> assertTrue(result.winners().contains("hyuns"))
        );
    }
}