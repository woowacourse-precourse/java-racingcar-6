package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class NameTest {

    @Test
    @DisplayName("자동차의 이름을 부여할 수 있다.")
    void createName() {
        Name name = new Name("hello");
        assertThat(name).isEqualTo(new Name("hello"));
    }

    @Test
    @DisplayName("자동차의 이름이 5자를 초과하면 예외가 발생한다.")
    void invalidName() {
        assertThatThrownBy(() -> new Name("banana"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 이름은 5자 이하여야 합니다.");
    }
}