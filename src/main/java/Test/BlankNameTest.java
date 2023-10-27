package Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import View.InputView;
import Validator.Validator;

import java.io.*;

public class BlankNameTest {

    InputView inputView = new InputView();

    @Test
    void 빈_입력(){
        String input = "\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(inputView::getNames)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Validator.getMessage("NOTHING"));
    }
}
