package study;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import racingcar.exception.RacingException;
import org.junit.jupiter.api.Test;

public class ExceptionTest {
    RacingException racingException = new RacingException();

    @Test
    public void 콤마가_연속으로_입력() {
        // given
        String inputStr = "포비,,수현";

        // when , then
        assertThatThrownBy(() -> racingException.validateCommaAfterComma(inputStr))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 콤마_뒤에_공백() {
        // given
        String inputStr = "포비, ";

        // when , then
        assertThatThrownBy(() -> racingException.validateIsNullAfterComma(inputStr))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 콤마_하나로_끝남() {
        // given
        String inputStr = "포비,";

        // when , then
        assertThatThrownBy(() -> racingException.validateLastCharIsComma(inputStr))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 자동차_이름_5자이상() {
        // given
        String inputStr = "포비포비포비,수현수현,수민";

        // when , then
        assertThatThrownBy(() -> racingException.validateCarNameLen(inputStr))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
