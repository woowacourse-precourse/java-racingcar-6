package racingcar.view.input;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class InputTryNumberErrorTest {
    private Input inputView = new Input();

    @Test
    void inputTryNumberThrowException() {
        InputStream readLine = setReadLine("5a");
        System.setIn(readLine);
        Assertions.assertThatThrownBy(() -> inputView.inputTryNumber())
                .isInstanceOf(IllegalArgumentException.class);
    }

    public static InputStream setReadLine(String readLine) {
        return new ByteArrayInputStream(readLine.getBytes());
    }
}
