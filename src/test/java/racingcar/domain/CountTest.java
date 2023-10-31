package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static racingcar.constant.ErrorMessage.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CountTest {

    @Test
    @DisplayName("시도 횟수를 올바르게 입력한다.")
    void count() {
        String countInput = "5";
        assertDoesNotThrow(() -> new Count(countInput));
    }

    @ParameterizedTest
    @CsvSource({"5.5", "ABC"})
    @DisplayName("시도 횟수를 올바르게 입력하지 않은 경우, 예외 처리한다.")
    void count2(String countInput) {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Count(countInput)
        );
        assertThat(exception.getMessage()).isEqualTo(NUMERIC_INPUT_ERROR.getMessage());
    }
}