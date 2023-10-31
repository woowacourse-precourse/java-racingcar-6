package validator.trynumber;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import racingcar.validator.Validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TryNumberTest {
    @DisplayName("trynumber_횟수가_1_이상의_숫자_외_예외_처리()")
    @Test
    void trynumber_횟수가_1_이상의_숫자_외_예외_처리() {
        String tryNumber = "k";
        Validator validator = new Validator();

        assertThatThrownBy(() -> validator.checkRegExpTryNumber(tryNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
