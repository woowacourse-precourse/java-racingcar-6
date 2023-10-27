package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class CarNameTest {
    @Test
    void 자동차의_이름이_5자_이하가_아니라면_예외를_발생시킨다() {
        assertThatThrownBy(() -> new CarName("abcdef"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Error: 자동차의 이름은 5자 이하여야 합니다.");
    }
}
