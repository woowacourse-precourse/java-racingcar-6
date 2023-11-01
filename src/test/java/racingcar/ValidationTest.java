package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.utils.Validator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class ValidationTest extends NsTest {
    
    @Test
    void 시도횟수_입력시_공백을_입력하면_예외_처리() {
        String input = " ";
        assertThatThrownBy(() -> {
            Validator.attemptCount(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도횟수_입력시_문자를_입력하면_예외_처리() {
        String input = "a";
        assertThatThrownBy(() -> {
            Validator.attemptCount(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
    
    @Test
    void 시도횟수_입력시_음수를_입력하면_예외_처리() {
        String input = "-1";
        assertThatThrownBy(() -> {
            Validator.attemptCount(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도횟수_입력시_0을_입력하면_예외_처리() {
        String input = "0";
        assertThatThrownBy(() -> {
            Validator.attemptCount(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
