package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {

    @Test
    @DisplayName("이름 생성 테스트")
    void create() {
        Name name = Name.of("pobi");

        assertThat(name).isEqualTo(Name.of("pobi"));
    }

    @Test
    @DisplayName("자동차 이름은 5자를 초과할 수 없다.")
    void createNameOver5() {
        assertThatThrownBy(() -> Name.of("pobicon"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름은 1자 이상이어야 한다.")
    void createNameUnder1() {
        assertThatThrownBy(() -> Name.of(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름은 null이 될 수 없다.")
    void createNameBlank() {
        assertThatThrownBy(() -> Name.of(null))
                .isInstanceOf(IllegalArgumentException.class);
    }
}