package Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import View.InputView;
import org.junit.jupiter.api.Test;
import Validator.Validator;

import java.io.*;

public class LongNameTest {
    @Test
    void 긴_이름(){
        InputView inputView = new InputView();
        String input = "test123456";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThatThrownBy(inputView::getNames)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Validator.getMessage("TOO_LONG_NAME"));
    }
}
