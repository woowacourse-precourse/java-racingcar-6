package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.constant.CarConstant.CAR_LIMIT_NAME_LENGTH;
import static racingcar.constant.CarConstant.CAR_NAME_SPLIT_STRING;
import static racingcar.exception.ErrorMessage.BLANK_NAME;
import static racingcar.exception.ErrorMessage.INVALID_NAME_LENGTH;
import static racingcar.exception.ErrorMessage.UNEXPECTED_STRING;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {

    @DisplayName("이름 길이는 " + CAR_LIMIT_NAME_LENGTH + "이하면 가능하다.")
    @ParameterizedTest
    @MethodSource
    void newName(String name) {

        Name name1 = new Name(name);

        assertThat(name1).isEqualTo(new Name(name));
    }

    static Stream<String> newName() {
        return Stream.iterate("A", str -> str  + "A")
                .limit(CAR_LIMIT_NAME_LENGTH);
    }

    @DisplayName("이름 길이는 " + CAR_LIMIT_NAME_LENGTH + "초과 불가능하다.")
    @ParameterizedTest
    @MethodSource
    void newNameLength(String name) {
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_NAME_LENGTH.getMessage());
    }

    static Stream<String> newNameLength() {
        return Stream.iterate("A", str -> str  + "A")
                .skip(CAR_LIMIT_NAME_LENGTH)
                .limit(10);
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
    @MethodSource
    void newNameSplit(String name) {

        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(UNEXPECTED_STRING.getMessage());
    }

    static Stream<String> newNameSplit() {
        return Stream.of(CAR_NAME_SPLIT_STRING,
                CAR_NAME_SPLIT_STRING + "A",
                "A" + CAR_NAME_SPLIT_STRING,
                "A" + CAR_NAME_SPLIT_STRING + "A",
                CAR_NAME_SPLIT_STRING + CAR_NAME_SPLIT_STRING);
    }
}