package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.InvalidInputException;

@DisplayName("RaceAttempts 클래스")
class RaceAttemptsTest {
    @Test
    @DisplayName("RaceAttempts 생성")
    void createRaceAttempts() {
        RaceAttempts raceAttempts = new RaceAttempts(3);
        assertEquals(3, raceAttempts.getAttempts());
    }

    @Test
    @DisplayName("RaceAttempts 생성 시 시도 횟수가 1 미만일 경우 예외 발생")
    void createRaceAttemptsFail() {
        assertThrows(InvalidInputException.class, () -> new RaceAttempts(0));
    }
}
