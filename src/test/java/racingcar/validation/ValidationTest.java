package racingcar.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class ValidationTest {
    @Test
    void 아무_입력도_들어오지_않은_경우_예외_처리() {
        String input = "";
        assertThatThrownBy(() -> new CarNames().checkNullInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
