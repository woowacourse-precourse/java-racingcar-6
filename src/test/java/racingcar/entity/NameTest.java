package racingcar.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {

    @DisplayName("생성 테스트")
    @Test
    void create() {
        Name name = Name.from("pobi");

        assertThat(name.getName()).isEqualTo("pobi");
    }

    @DisplayName("알 수 없는 이름(null)으로 객체를 생성할 수 없다.")
    @Test
    void createWithNull() {
        assertThatThrownBy(() -> Name.from(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("알 수 없는 이름입니다.");
    }

    @DisplayName("이름의 길이는 최대 5글자이다.")
    @Test
    void checkNameLength() {
        assertThatThrownBy(() -> Name.from("*".repeat(6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 최대 5글자까지 입력할 수 있습니다.");
    }
}
