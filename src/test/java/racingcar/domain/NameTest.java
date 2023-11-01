package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class NameTest {

    @Test
    @DisplayName("이름이 5글자 이하면 Name이 생성된다.")
    void nameCreateTest() {
        // given
        String value = "pobi1";

        // when
        Name name = new Name(value);

        // then
        assertAll(
                () -> assertThat(name).isInstanceOf(Name.class),
                () -> assertThat(name).isEqualTo(new Name("pobi1"))
        );
    }

    @Test
    @DisplayName("이름이 6글자 이상이면 IllegalArgumentException이 발생한다.")
    void nameCreateLengthErrorTest() {
        // given
        String value = "";

        // when

        // then
        assertThatThrownBy(() -> new Name(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 자동차 이름은 1글자 이상 5글자 이하만 가능합니다.");
    }
}
