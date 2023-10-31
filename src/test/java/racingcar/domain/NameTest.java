package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.constant.CarConstant.CAR_LIMIT_NAME_LENGTH;
import static racingcar.constant.CarConstant.CAR_NAME_SPLIT_STRING;
import static racingcar.exception.ErrorMessage.BLANK_NAME;
import static racingcar.exception.ErrorMessage.INVALID_NAME_LENGTH;
import static racingcar.exception.ErrorMessage.UNEXPECTED_STRING;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {

    @DisplayName("이름 길이는 " + CAR_LIMIT_NAME_LENGTH + "이하면 가능하다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "12", "123", "1234", "12345", " a", "a ", "a a"})
    void newName(String name) {

        Name name1 = new Name(name);

        assertThat(name1).isEqualTo(new Name(name));
    }

    @DisplayName("이름 길이는 " + CAR_LIMIT_NAME_LENGTH + "초과 불가능하다.")
    @ParameterizedTest
    @ValueSource(strings = {"123456", "abcdef", "12345678", "123456789", "123456789012345"})
    void newNameLength(String name) {
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_NAME_LENGTH.getMessage());
    }

    @DisplayName("빈문자를 이름으로 할 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "\n", "   "})
    void newNameBlank(String name) {

        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BLANK_NAME.getMessage());
    }

    @DisplayName("'" + CAR_NAME_SPLIT_STRING + "' 포함한 이름을 생성할 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {",", "a,b", ",a", "a,", ",,,"})
    void newNameSplit(String name) {

        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(UNEXPECTED_STRING.getMessage());
    }
}