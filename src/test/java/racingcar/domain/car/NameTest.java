package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("NameTest")
class NameTest {

    @Test
    @DisplayName("자동차의 이름을 반환한다.")
    void getName() {
        // given
        String input = "name1";
        Name name = new Name(input);

        // when
        String getName = name.getName();

        // then
        assertThat(input).isEqualTo(getName);
    }
}