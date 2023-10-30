package racingcar.view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Test;

class InputViewTest {
    void systemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @Test
    void 횟수_0_입력시_예외_발생() {
        systemIn("0");
        assertThatThrownBy(InputView::askAttemptNumber)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 횟수_음수_입력시_예외_발생() {
        systemIn("-1");
        assertThatThrownBy(InputView::askAttemptNumber)
                .isInstanceOf(IllegalArgumentException.class);
    }
}