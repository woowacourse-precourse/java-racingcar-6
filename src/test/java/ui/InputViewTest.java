package ui;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest {

    @Test
    void inputCarNames_ValidInput() {
        String input = "car1,car2,car3";
        provideInput(input);

        assertThat(InputView.inputCarNames()).containsExactly("car1", "car2", "car3");
    }

    private void provideInput(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }
}
