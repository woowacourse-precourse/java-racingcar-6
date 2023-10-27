package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    @DisplayName("자동차 이름이 5글자 초과인 경우 예외")
    void name_greater_than_5() {
        assertThatThrownBy(() -> new Car("123456", 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("자동차 이름은 [0-9]~[0-9] 사이여야 합니다.");
    }

    @Test
    @DisplayName("자동차 이름에 알파벳과 숫자 외 문자가 있는 경우 예외")
    void name_not_allowed_character() {
        assertThatThrownBy(() -> new Car("ab12^", 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름에는 알파벳과 숫자만 사용할 수 있습니다.");
    }
}
