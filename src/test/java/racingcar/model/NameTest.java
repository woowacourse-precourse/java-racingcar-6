package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static racingcar.view.exception.ExceptionMessage.NAME_LENGTH_EXCEPTION;
import static racingcar.view.exception.ExceptionMessage.NAME_VALUE_BLANK_EXCEPTION;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NameTest {

    @ParameterizedTest
    @ValueSource(strings = {"  bob", "bob  ", "b o b"})
    @DisplayName("공백이 포함되면 안 된다.")
    void haveBlankExceptionTest(final String value) {
        // given & when & then
        assertThatThrownBy(() -> {
            Name name = Name.from(value);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NAME_VALUE_BLANK_EXCEPTION.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"nickname", ""})
    @DisplayName("이름 길이는 1자 이상 5자 이하여야 한다.")
    void lengthExceptionTest(final String value) {
        // given & when & then
        assertThatThrownBy(() -> {
            Name name = Name.from(value);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NAME_LENGTH_EXCEPTION.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"bob", "123", "john", "12a"})
    @DisplayName("공백이 없고 길이가 5자 이하면 정상 생성 된다.")
    void correctNameValueTest(final String value) {
        // given & when & then
        assertDoesNotThrow(() -> {
            Name name = Name.from(value);
        });
    }
}
