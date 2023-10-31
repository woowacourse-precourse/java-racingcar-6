package validator.status;

import racingcar.message.ErrorMessage;
import racingcar.validator.Validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StatusTest {
    @DisplayName("status_상태값이_1_or_2_외면_예외_처리")
    @Test
    void status_상태값이_1_or_2_외면_예외_처리() {
        String input = "k";

        Validator validator = new Validator();

        assertThatThrownBy(() -> validator.checkRegExpProcess(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.EXCEPTION_STATUS);
    }
}
