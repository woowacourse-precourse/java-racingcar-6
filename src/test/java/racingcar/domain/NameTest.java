package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class NameTest {

    @ParameterizedTest
    @ValueSource(strings = {"i", "hello"})
    @DisplayName("자동차의 이름을 부여할 수 있다.")
    void createName(String input) {
        Name name = new Name(input);
        assertThat(name).isEqualTo(new Name(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "banana"})
    @DisplayName("자동차의 이름이 1자 미만이거나 5자를 초과하면 예외가 발생한다.")
    void invalidName(String name) {
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 이름은 1자 이상, 5자 이하여야 합니다.");
    }
}