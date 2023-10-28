package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class TextSplitValidatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"non-separable-words"})
    @DisplayName("쉼표로 분할할 수 없는 이름이면 예외가 발생한다.")
    void canNotSplitByComma_Then_ExceptionOccurs(final String words) {
        assertThatThrownBy(() -> TextSplitValidator.validate(words)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
