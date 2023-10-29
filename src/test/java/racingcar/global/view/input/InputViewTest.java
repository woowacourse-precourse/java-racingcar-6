package racingcar.global.view.input;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest {

    void setUp(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @DisplayName("stringInput입력시 정상적으로 입력되는지 확인")
    @Test
    void stringInputTest() {
        String expected = "우테코 합격시켜주세요";
        setUp(expected);

        String result = InputView.stringInput();

        assertThat(result)
                .isEqualTo(expected);
    }

    @DisplayName("stringInput에 null 입력시 IllegalArgumentException 호출하는지 테스트")
    @Test
    void stringInputThrowExceptionInputNull() {
        setUp("\n");

        assertThatThrownBy(InputView::stringInput)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Input cannot be null");
    }

    @DisplayName("integerInput에 숫자 외 문자 입력시 IllegalArgumentException 호출하는지 테스트")
    @Test
    void integerInputThrowExceptionInputNull() {
        String input = "a";
        setUp(input);

        assertThatThrownBy(InputView::integerInput)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("문자가 아닌 숫자를 입력해주세요");
    }
}
