package Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import Validator.Validator;
import View.InputView;
import java.io.*;
import org.junit.jupiter.api.Test;

public class NotNumberTrialTest {

    @Test
    void 숫자가_아닌_입력() {
        InputView inputView = new InputView();
        String input = "12times";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(inputView::getTrial)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Validator.getMessage("NOT_NUMBER"));
    }
}
