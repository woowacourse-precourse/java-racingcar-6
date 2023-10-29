package racingcar.View;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class InputViewTest {
    private InputView inputView;

    private void systemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @BeforeEach
    void setInputView() {
        inputView = new InputView();
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void 자동차이름_입력_후_리스트변환() {
        systemIn("jung,yuju,dong");
        List<String> expect = Arrays.asList("jung", "yuju", "dong");
        List<String> result = inputView.inputCarName();
        assertThat(result).isEqualTo(expect);


    }
}