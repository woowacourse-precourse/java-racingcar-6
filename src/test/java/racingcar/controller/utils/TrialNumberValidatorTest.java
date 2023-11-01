package racingcar.controller.utils;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class TrialNumberValidatorTest {

    @Test
    void 정상() {
        TrialNumberValidator validator = new TrialNumberValidator();
        String input = "1";
        assertThatCode(() -> validator.validateTrialNumberInput(input))
                .doesNotThrowAnyException();
    }

    @Test
    void 공백입력_예외_처리() {
        TrialNumberValidator validator = new TrialNumberValidator();
        String input = "";
        assertThatThrownBy(() -> validator.validateTrialNumberInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("값을 입력하세요");
    }

    @Test
    void  입력값이_숫자가_아닐때_예외_처리() {
        TrialNumberValidator validator = new TrialNumberValidator();
        String input = "aaa";
        assertThatThrownBy(() -> validator.validateTrialNumberInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자를 입력해야 합니다.");
    }


}