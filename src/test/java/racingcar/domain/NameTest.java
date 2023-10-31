package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {

    @DisplayName("자동차 이름으로 빈 문자열이 들어오면 예외가 발생한다.")
    @Test
    void validateCarNameEmptyOrNull() {
        // given
        String name = "";

        // when, then
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class);
    }
}