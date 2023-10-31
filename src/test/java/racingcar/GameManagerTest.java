package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameManagerTest {

    @Test
    @DisplayName("잘못된 값 예외 발생")
    void getNames() {

        String[] case1 = {""};
        assertThatThrownBy(() -> GameManager.validate(case1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름을 입력해주세요.");

        String[] case2 = {"abc", "", "def"};
        assertThatThrownBy(() -> GameManager.validate(case2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름을 입력해주세요.");

        String[] case3 = {"abcde", "fghij", "aaaaaa"};
        assertThatThrownBy(() -> GameManager.validate(case3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 5자 이하만 가능합니다.");
    }
}