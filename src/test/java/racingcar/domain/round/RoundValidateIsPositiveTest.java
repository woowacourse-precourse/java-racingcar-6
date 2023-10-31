package racingcar.domain.round;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RoundValidateIsPositiveTest {

    @Test
    @DisplayName("라운드 횟수는 양수를 허용한다.")
    void validateRoundIsPositiveSuccessTest() {
        // given
        int value = 1;

        // then
        Assertions.assertDoesNotThrow(() -> {
            new Round(value);
        });
    }

    @ParameterizedTest
    @DisplayName("라운드 횟수는 0과 음수를 불허한다.")
    @CsvSource(value = {
            "0", "-1"
    })
    void validateRoundIsPositiveFailTest(int value) {
        // then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Round(value);
        });
    }

}