package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarNameTest {
    @Test
    void 자동차의_이름이_5자_이하가_아니라면_예외를_발생시킨다() {
        assertThatThrownBy(() -> new CarName("abcdef"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Error: 자동차의 이름은 5자 이하여야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "ab", "abc", "abcd", "abcde"})
    void 자동차의_이름은_5자_이하여야_한다(String name) {
        assertThatCode(() -> new CarName(name))
                .doesNotThrowAnyException();
    }
}
