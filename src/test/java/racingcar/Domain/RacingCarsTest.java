package racingcar.Domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.*;
import static racingcar.Message.ExceptionMessage.NULL_ERROR;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.Exception.CarException;

class RacingCarsTest {

    @ParameterizedTest
    @ValueSource(strings = {"pobi, nana, bbo"})
    @DisplayName("올바른 값이 들어오면 예외 없음")
    void givenValidCarNames_shouldNotThrowCreateExceptions(final String names) {
        // given
        RacingCars racingCars = new RacingCars(names);

        assertThatCode(() -> RacingCars.create(names))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @NullSource
    @DisplayName("NULL 값이 들어오면 예외 처리")
    void givenValidCarNames_shouldThrowCreateExceptions(final String names) {
        // given
        RacingCars racingCars;

        assertThatCode(() -> RacingCars.create(names)).hasMessageContaining(NULL_ERROR);
    }
}