package Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import View.InputView;
import Validator.Validator;

import java.io.*;

public class LessThenZeroTrialTest {

    @Test
    void 음수_입력(){
        InputView inputView = new InputView();
        String input = "-1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(inputView::getTrial)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Validator.getMessage("LESS_THEN_ZERO"));
    }
}
