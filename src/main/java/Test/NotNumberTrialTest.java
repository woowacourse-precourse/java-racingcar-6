package Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import View.InputView;
import Validator.Validator;

import java.io.*;

public class NotNumberTrialTest {

    @Test
    void 숫자가_아닌_입력(){
        InputView inputView = new InputView();
        String input = "12times";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(inputView::getTrial)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Validator.getMessage("NOT_NUMBER"));
    }
}
