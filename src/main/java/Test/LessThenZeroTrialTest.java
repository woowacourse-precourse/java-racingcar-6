package Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import Validator.Validator;
import View.InputView;
import java.io.*;
import org.junit.jupiter.api.Test;

public class LessThenZeroTrialTest {

    @Test
    void 음수_입력() {
        InputView inputView = new InputView();
        String input = "-1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(inputView::getTrial)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Validator.getMessage("LESS_THEN_ZERO"));
    }
}
