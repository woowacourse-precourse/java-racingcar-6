package racingcar.Exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class RaceExceptionTest {
    RaceException raceException = new RaceException();

    @ParameterizedTest
    @DisplayName("유효한 숫자는 예외를 발생시키지 않아야 합니다.")
    @ValueSource(strings = {"1", "500", "3000"})
    void givenValidRaceCount_shouldNotThrowExceptions(String tryCount) {

        assertThatCode(() -> raceException.checkExceptionRace(tryCount))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("유효하지 않은 숫자는 예외를 발생시켜야 합니다.")
    @ValueSource(strings = {"", " ", "1 0", "1.15", "0", "한번", "A"})
    void givenInvalidRaceCount_shouldThrowExceptions(String tryCount) {

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> raceException.checkExceptionRace(tryCount));
    }
}