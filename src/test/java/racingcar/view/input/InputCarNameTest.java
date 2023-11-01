package racingcar.view.input;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;


class InputTest {
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

    @Test
    @DisplayName("차 이름 받는 로직 중 이름이 5자 초과인 로직 확인")
    void inputCarNamesThrowError() {
        InputStream readLine = setReadLine("pobiee2,aaa,bbb");
        System.setIn(readLine);
        Assertions.assertThatThrownBy(() -> inputView.inputCarNames())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void inputTryNumber() {
        InputStream readLine = setReadLine("5");
        System.setIn(readLine);

        Integer expect = 5;
        Integer actual = inputView.inputTryNumber();

        Assertions.assertThat(actual).isEqualTo(expect);
    }

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