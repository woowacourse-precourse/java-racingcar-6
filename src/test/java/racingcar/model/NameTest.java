package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NameTest {

    @DisplayName("이름을 정상적으로 불러오는지 확인")
    @Test
    void getName() {
        // given
        final String nameStr = "이름";
        final Name name = new Name(nameStr);

        // when
        String getName = name.getName();

        // then
        assertThat(getName).isEqualTo(nameStr);
    }

    @DisplayName("빈 이름은 생성할 수 없다")
    @Test
    void createNameThrowCase1() {
        // given
        final String name = "";

        // when, then
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름 값이 없습니다.");
    }

    @DisplayName("긴 이름은 생성할 수 없다")
    @Test
    void createNameThrowCase2() {
        // given
        final String name = "123456";

        // when, then
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름의 길이가 5보다 큽니다.");
    }
}