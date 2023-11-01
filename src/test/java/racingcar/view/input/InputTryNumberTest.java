package racingcar.view.input;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class InputTryNumberTest {
    private Input inputView = new Input();

    @Test
    void inputTryNumber() {
        InputStream readLine = setReadLine("5");
        System.setIn(readLine);

        Integer expect = 5;
        Integer actual = inputView.inputTryNumber();

        Assertions.assertThat(actual).isEqualTo(expect);
    }

    public static InputStream setReadLine(String readLine) {
        return new ByteArrayInputStream(readLine.getBytes());
    }
}
