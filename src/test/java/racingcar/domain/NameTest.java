package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
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

    @DisplayName("자동차 이름으로 1~5 사이가 아닌 문자열이 들어오면 예외가 발생한다.")
    @Test
    void validateCarNameLength() {
        // given
        String name = "Program";

        // when, then
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("올바른 자동차 이름을 반환한다.")
    @Test
    void getValue() {
        // given
        String carName = "pobi";
        Name name = new Name(carName);

        // when
        String getName = name.getValue();

        // then
        assertThat(getName).isEqualTo(carName);
    }
}