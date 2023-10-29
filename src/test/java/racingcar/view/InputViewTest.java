package racingcar.view;


import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;

public class InputViewTest {

    @ParameterizedTest
    @EmptySource
    @NullSource
    @NullAndEmptySource
    @CsvSource({"123", "-1", "-99", "string", "s", "가", "00", "1 0", "0 8"})
    void 시도횟수_예외처리(String tryCountFromUser) {
        assertThatThrownBy(() -> InputView.validateTryCount(tryCountFromUser))
                .isInstanceOf(IllegalArgumentException.class);
    }
}