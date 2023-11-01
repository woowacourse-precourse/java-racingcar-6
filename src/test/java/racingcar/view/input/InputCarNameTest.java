package racingcar.view.input;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;


class InputCarNameTest {
    private Input inputView = new Input();

    @Test
    @DisplayName("차 이름 받는 로직 테스트")
    void inputCarNames() {
        InputStream readLine = setReadLine("pobi,woni,jun");
        System.setIn(readLine);

        String[] expect = new String[]{"pobi", "woni", "jun"};
        String[] actual = inputView.inputCarNames();

        Assertions.assertThat(actual).isEqualTo(expect);
    }

    public static InputStream setReadLine(String readLine) {
        return new ByteArrayInputStream(readLine.getBytes());
    }
}