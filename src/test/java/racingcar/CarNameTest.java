package racingcar;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class CarNameTest {

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "      "})
    @DisplayName("이름이 null이거나 빈 문자열이면 예외가 발생한다.")
    void isNameNullOrEmpty_Then_ExceptionOccurs(final String name) {
        assertThatThrownBy(() -> CarName.valueOf(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("다섯 글자를 초과한 이름이 입력되면 예외가 발생한다.")
    void exceedFiveLetters_Then_ExceptionOccurs() {
        assertThatThrownBy(() -> CarName.valueOf("123456"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "car", "car3", "12345"})
    @DisplayName("다섯 글자 이하의 이름이 입력되면 예외가 발생하지 않는다.")
    void lessThenFiveLetters_Then_NoExceptionOccurs(final String name) {
        assertThatCode(() -> CarName.valueOf(name))
                .doesNotThrowAnyException();
    }
}
