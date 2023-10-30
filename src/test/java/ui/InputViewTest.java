package ui;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {

    @Test
    void inputCarNames_ValidInput() {
        String input = "car1,car2,car3";
        provideInput(input);

        assertThat(InputView.inputCarNames()).containsExactly("car1", "car2", "car3");
    }

    @Test
    void inputCarNames_NameTooLong() {
        String input = "car1,car2,car3456789";
        provideInput(input);

        assertThatThrownBy(InputView::inputCarNames)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하여야 합니다.");
    }

    private void provideInput(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }
}
