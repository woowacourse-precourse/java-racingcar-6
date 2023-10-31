package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarNameTest {
    @Test
    void 빈_값_예외_처리() {
        String input = "";

        Assertions.assertThatThrownBy(() -> new CarName(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("빈칸입니다.");
    }

    @Test
    void 이름_개수_예외_처리() {
        String input = "abc";

        Assertions.assertThatThrownBy(() -> new CarName(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("두 개 이상 적어주세요.");
    }

    @Test
    void 이름_길이_예외_처리() {
        String input = "abcd,abcdef";

        Assertions.assertThatThrownBy(() -> new CarName(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("5자 이하만 가능합니다.");
    }

    @Test
    void 이름_중복_예외_처리() {
        String input = "abcd,abcd,efgh";

        Assertions.assertThatThrownBy(() -> new CarName(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 이름이 있습니다.");
    }
}
