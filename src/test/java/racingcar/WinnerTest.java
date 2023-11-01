package racingcar;

import racingcar.validator.CarNameInputValidator;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class WinnerTest {
    @Test
    void 비어있는_값_검증() {
        CarNameInputValidator validator = new CarNameInputValidator();
        assertThatThrownBy(() -> validator.validate(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력값이 존재하지 않습니다.");
    }
}