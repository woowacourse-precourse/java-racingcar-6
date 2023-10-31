package validator.trynumber;

import racingcar.message.ErrorMessage;
import racingcar.validator.Validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TryNumberTest {
    @DisplayName("trynumber_횟수가_1_이상의_숫자_외_예외_처리()")
    @Test
    void trynumber_횟수가_1_이상의_숫자_외_예외_처리() {
        String tryNumber = "k";
        Validator validator = new Validator();

        assertThatThrownBy(() -> validator.checkRegExpTryNumber(tryNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.EXCEPTION_TRY_NUMBER);;
    }
}
