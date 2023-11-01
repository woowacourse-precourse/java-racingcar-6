package racingcar.validation;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
public class InputValidatorTest {
    @Test
    public void 자동차_이름이_5글자_초과() {
        assertThatThrownBy(() -> InputValidator.validateCarName("abcdef"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름이 5글자를 초과해선 안됩니다.");
    }

    @Test
    public void 자동차_이름이_비어있는_경우() {
        assertThatThrownBy(() -> InputValidator.validateCarName(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름이 비어있습니다.");
    }

    @Test
    public void 이동횟수가_0이거나_음수일때() {
        assertThatThrownBy(() -> InputValidator.validateMovement(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이동횟수가 0 이하입니다.");
    }

    @Test
    public void 입력형식이_잘못되었을때() {
        assertThatThrownBy(() -> InputValidator.validateInputFormat("abc,def,123,"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력형식이 올바르지 않습니다.");
    }

}
