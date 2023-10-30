package racingcar.View;

import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest {
    @Test
    public void testInputView() {
        InputView inputView = new InputView();
        assertThat(inputView).isNotNull();
    }
}
