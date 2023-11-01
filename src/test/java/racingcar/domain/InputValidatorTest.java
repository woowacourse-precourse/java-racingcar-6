package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class InputValidatorTest {
    @Test
    void 양수_정수_입력인지_확인() {
        List<String> input = List.of("3", "0", "-3", "123", "a", "13a", "a13", "-0");
        List<Boolean> result = List.of(true, false, false, true, false, false, false, false);
        for (int i = 0; i < input.size(); ++i) {
            assertThat(InputValidator.isPositiveNumber(input.get(i))).isEqualTo(result.get(i));
        }
    }
}