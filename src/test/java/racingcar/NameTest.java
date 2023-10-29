package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static racingcar.ExceptionMessage.CAR_NAME_BLANK_EXCEPTION;
import static racingcar.ExceptionMessage.CAR_NAME_LENGTH_EXCEPTION;
import static racingcar.ExceptionMessage.CAR_NAME_VALUE_EXCEPTION;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.Name;

public class NameTest {

    @Test
    @DisplayName("이름은 5자 이하만 가능하다 - 정상")
    void underFiveLengthNameTest() {
        // given & when & then
        assertDoesNotThrow(() -> {
            Name name = Name.from("john");
        });
    }

    @Test
    @DisplayName("이름은 5자 이하만 가능하다 - 예외")
    void lengthExceptionTest() {
        // given & when & then
        assertThatThrownBy(() -> {
            Name name = Name.from("nickname");
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CAR_NAME_LENGTH_EXCEPTION.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"  bob", "bob  ", "b o b", "  "})
    @DisplayName("공백이 포함되면 안 된다")
    void haveBlankNameExceptionTest(final String value) {
        // given & when & then
        assertThatThrownBy(() -> {
            Name name = Name.from(value);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CAR_NAME_BLANK_EXCEPTION.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"존", "1a9"})
    @DisplayName("한글이나 알파벳, 숫자는 가능하다")
    void koreanOrAlphabetOrNumericTest(final String value) {
        // given & when & then
        assertDoesNotThrow(() -> {
            Name name = Name.from(value);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"崔はлن", "?-bob"})
    @DisplayName("한글과 알파벳, 숫자를 제외한 모든 문자는 안 된다")
    void unvalidNameValueExceptionTest(final String value) {
        // given & when & then
        assertThatThrownBy(() -> {
            Name name = Name.from(value);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CAR_NAME_VALUE_EXCEPTION.getMessage());
    }
}
