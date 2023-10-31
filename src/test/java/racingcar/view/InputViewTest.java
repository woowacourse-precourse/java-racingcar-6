package racingcar.view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import racingcar.util.Validator;

public class InputViewTest {

    @ParameterizedTest
    @EmptySource
    @NullSource
    @NullAndEmptySource
    @CsvSource({"-1", "-99", "string", "s", "가", "1 0", "0 8", "1*9", "1+1"})
    void 시도횟수_예외처리(String tryCountFromUser) {
        assertThatThrownBy(() -> Validator.validateTryCount(tryCountFromUser))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @EmptySource
    @NullSource
    @NullAndEmptySource
    @CsvSource(value = {"자동차.자동차2345", "자동차1,racing"}, delimiter = '/')
    void 자동차이름_예외처리(String namesFromUser) {
        assertThatThrownBy(() -> Validator.validateNames(namesFromUser))
                .isInstanceOf(IllegalArgumentException.class);
    }
}