package Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import Validator.Validator;
import View.InputView;
import java.io.*;
import org.junit.jupiter.api.Test;

public class BlankNameTest {

    InputView inputView = new InputView();

    @Test
    void 빈_입력() {
        String input = "\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(inputView::getNames)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Validator.getMessage("NOTHING"));
    }
}
