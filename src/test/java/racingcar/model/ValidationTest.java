package racingcar.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class ValidationTest {

    @Test
    public void 이름_길이_5자리_이하만_가능() {
        List<Cars> input1 = Arrays.asList(new Cars("JiHun", 0), new Cars("MacBook", 0));

        assertThatThrownBy(() -> Validation.name(input1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 5자리 이하만 가능");
    }

    @Test
    public void 이름_중복_금지() {
        List<Cars> input = Arrays.asList(new Cars("JiHun", 0), new Cars("JiHun", 0));

        assertThatThrownBy(() -> Validation.name(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 중복될 수 없습니다");
    }

    @Test
    public void 회수는_양의_정수만_입력_가능() {
        String input1 = "string";
        String input2 = "-1";

        assertThatThrownBy(() -> Validation.isPositiveInt(input1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("회수는 정수만 입력 가능합니다.");

        assertThatThrownBy(() -> Validation.isPositiveInt(input2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("회수는 양의 정수만 입력 가능합니다.");
    }
}