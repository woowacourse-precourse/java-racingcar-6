package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.exception.ErrorMessage.BLANK_NAME;
import static racingcar.exception.ErrorMessage.INVALID_NAME_LENGTH;
import static racingcar.exception.ErrorMessage.UNEXPECTED_STRING;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "12", "123", "1234", "12345", " a", "a ", "a a"})
    @DisplayName("이름 길이는 5이하 가능")
    void 이름길이_5_이하(String name) {

        Name name1 = new Name(name);

        assertThat(name1).isEqualTo(new Name(name));
    }

    @ParameterizedTest
    @ValueSource(strings = {"123456", "abcdef", "12345678", "123456789", "123456789012345"})
    @DisplayName("이름 길이는 5초과 불가능")
    void 이름길이_5초과_예외(String name) {
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_NAME_LENGTH.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "\n", "   "})
    @DisplayName("빈문자는 생성 불가능")
    void 빈문자_예외(String name) {

        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BLANK_NAME.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {",", "a,b", ",a", "a,", ",,,"})
    @DisplayName("구분자 포함 불가능")
    void 구분자_포함_예외(String name) {

        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(UNEXPECTED_STRING.getMessage());
    }
}