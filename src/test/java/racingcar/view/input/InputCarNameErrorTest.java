package racingcar.view.input;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class InputCarNameErrorTest {
    private Input inputView = new Input();

    @Test
    @DisplayName("차 이름 받는 로직 중 이름이 5자 초과인 로직 확인")
    void inputCarNamesThrowError() {
        InputStream readLine = setReadLine("pobiee2,aaa,bbb");
        System.setIn(readLine);
        Assertions.assertThatThrownBy(() -> inputView.inputCarNames())
                .isInstanceOf(IllegalArgumentException.class);
    }

    public static InputStream setReadLine(String readLine) {
        return new ByteArrayInputStream(readLine.getBytes());
    }
}
