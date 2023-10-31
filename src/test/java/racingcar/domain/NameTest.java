package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.message.ErrorMessage.CAR_NAME_LENGTH_EXCEPTION_MESSAGE;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {

    @DisplayName("이름 길이 성공")
    @ParameterizedTest
    @ValueSource(strings = {"성공", "길이성공"})
    void 이름_길이_성공(String value) {
        assertThatCode(() -> new Name(value))
                .doesNotThrowAnyException();
    }

    @DisplayName("이름 길이 실패")
    @ParameterizedTest
    @ValueSource(strings = {"", "여섯글자이름"})
    void 이름_길이_실패(String value) {
        assertThatThrownBy(() -> new Name(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CAR_NAME_LENGTH_EXCEPTION_MESSAGE);
    }

    @DisplayName("이름 앞 뒤 공백 제거 테스트")
    @ParameterizedTest
    @ValueSource(strings = {" 앞공백", "뒤공백 "})
    void 이름_공백_제거(String value) {
        Name name = new Name(value);

        assertThat(value.trim()).isEqualTo(name.value());
    }
}