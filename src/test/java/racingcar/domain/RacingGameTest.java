package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RacingGameTest {
    @ParameterizedTest
    @DisplayName("경주 횟수 1 미만 값 입력 시 예외 테스트")
    @ValueSource(ints = {-1, 0})
    void raceCountLessThanOneFailTest(int raceCount) {
        Cars cars = Cars.createCarsUsingCarNames(List.of("1번자동차", "2번자동차", "3번자동차"));
        RacingGame racingGame = new RacingGame(cars);
        assertThrows(IllegalArgumentException.class, () -> racingGame.race(raceCount));
    }

    @Test
    @DisplayName("경주 횟수 1 이상 값 입력 시 정상 진행 테스트")
    void raceSuccessTest() {
        Cars cars = Cars.createCarsUsingCarNames(List.of("1번자동차", "2번자동차", "3번자동차"));
        RacingGame racingGame = new RacingGame(cars);
        assertDoesNotThrow(() -> racingGame.race(1));
    }
}