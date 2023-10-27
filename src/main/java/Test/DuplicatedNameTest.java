package Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import Validator.Validator;
import View.InputView;
import java.io.*;
import org.junit.jupiter.api.Test;

public class DuplicatedNameTest {

    @Test
    void 중복된_이름() {
        InputView inputView = new InputView();
        String input = "test,test,test1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(inputView::getNames)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Validator.getMessage("DUPLICATED_NAME"));
    }
}
