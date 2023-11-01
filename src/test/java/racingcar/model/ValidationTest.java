package racingcar.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static racingcar.util.Message.COUNT_MUST_INT;
import static racingcar.util.Message.COUNT_MUST_POSITIVE_INT;
import static racingcar.util.Message.NAME_LIMIT_LENGTH;
import static racingcar.util.Message.NAME_MUST_SIZE;
import static racingcar.util.Message.NAME_NO_DISTINCT;
import static racingcar.util.Message.NAME_NO_WHITESPACE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class ValidationTest {

    @Test
    public void 이름_길이_5자리_이하만_가능() {
        List<Car> input1 = Arrays.asList(new Car("JiHun", 0), new Car("MacBook", 0));

        assertThatThrownBy(() -> Validation.name(input1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NAME_LIMIT_LENGTH);
    }

    @Test
    public void 이름_중복_금지() {
        List<Car> input = Arrays.asList(new Car("JiHun", 0), new Car("JiHun", 0));

        assertThatThrownBy(() -> Validation.name(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NAME_NO_DISTINCT);
    }

    @Test
    public void 이름_한개_이상_참여() {
        List<Car> input = new ArrayList<>();

        assertThatThrownBy(() -> Validation.name(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NAME_MUST_SIZE);
    }

    @Test
    public void 이름이_공백만_있는건_금지() {
        List<Car> input = Arrays.asList(new Car(" ", 0));

        assertThatThrownBy(() -> Validation.name(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NAME_NO_WHITESPACE);
    }

    @Test
    public void 횟수는_정수만_입력_가능() {
        String input = "string";

        assertThatThrownBy(() -> Validation.isPositiveInt(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(COUNT_MUST_INT);
    }

    @Test
    public void 횟수는_양의_정수만_입력_가능() {
        String input = "-1";

        assertThatThrownBy(() -> Validation.isPositiveInt(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(COUNT_MUST_POSITIVE_INT);
    }
}