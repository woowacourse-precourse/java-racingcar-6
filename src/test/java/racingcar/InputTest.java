package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.utils.InputValidator;

public class InputTest {

    @Test
    void 이름_길이_예외_처리_1() {
        List<String> list = List.of("pobiiiii", "pobi", "goni");
        assertThatThrownBy(() -> InputValidator.checkNameLength(list)).isInstanceOf(
                IllegalArgumentException.class);
    }

}
