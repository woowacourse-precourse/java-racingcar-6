package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarNameTest {

    private static final int MAX_NUM_LENGTH = 5;

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
                .hasMessageContaining("자동차 이름을 2개 이상 입력하세요.");
    }

    @Test
    void 이름_길이_예외_처리() {
        String input = "abcd,abcdef";

        Assertions.assertThatThrownBy(() -> new CarName(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format("최대 이름 길이인 %d를 넘는 이름입니다.", MAX_NUM_LENGTH));
    }

    @Test
    void 이름_중복_예외_처리() {
        String input = "abcd,abcd,efgh";

        Assertions.assertThatThrownBy(() -> new CarName(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름 중에 중복이 있습니다.");
    }

}
