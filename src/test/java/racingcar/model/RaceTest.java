package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RaceTest {

    @DisplayName("race 회수 유효성 검사 테스트")
    @Test
    void testValidateNumberOfRace() {
        assertDoesNotThrow(() -> new Race(5));
    }

    @DisplayName("race 회수 유효성 검사 exception 테스트")
    @Test
    void testValidateNumberOfRaceThrow() {
        assertThrows(IllegalArgumentException.class,() -> new Race(101));
    }
}
