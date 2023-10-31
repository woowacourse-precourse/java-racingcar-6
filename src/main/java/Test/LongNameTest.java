package Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import Validator.Validator;
import View.InputView;
import java.io.*;
import org.junit.jupiter.api.Test;

public class LongNameTest {

    @Test
    void 긴_이름() {
        InputView inputView = new InputView();
        String input = "test123456";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThatThrownBy(inputView::getNames)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Validator.getMessage("TOO_LONG_NAME"));
    }
}
