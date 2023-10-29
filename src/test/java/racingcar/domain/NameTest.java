package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class NameTest {

    @Test
    @DisplayName("이름을 반환한다.")
    void getValue() {
        Name test1 = new Name("test1");
        Assertions.assertThat(test1.getValue()).isEqualTo("test1");
    }

    @ParameterizedTest
    @ValueSource(strings = {"   ", ""})
    @DisplayName("이름에 공백이 있으면 에러가 발생한다.")
    void shouldThrowExceptionWhenEmpty(String input) {
        assertThrows(IllegalArgumentException.class, () -> new Name(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"123456", "가나다라마바사", "abas  qwe", "a b  c"})
    @DisplayName("이름의 길이가 설정된 길이를 초과하면 에러가 발생한다.")
    void shouldThrowExceptionWhenNameLengthIsOver(String input) {
        assertThrows(IllegalArgumentException.class, () -> new Name(input));
    }
}