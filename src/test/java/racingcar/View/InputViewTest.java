package racingcar.View;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest {
    @Test
    public void testInputView() {
        InputView inputView = new InputView();
        assertThat(inputView).isNotNull();
    }
}
