package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class CarNameTest {

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "      "})
    @DisplayName("이름이 null이거나 빈 문자열이면 예외가 발생한다.")
    void isNameNullOrEmpty_Then_ExceptionOccurs(final String name) {
        assertThatThrownBy(() -> CarName.of(name))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
