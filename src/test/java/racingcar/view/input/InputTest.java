package racingcar.view.input;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;


class InputTest {
    private final Input inputView = new Input();

    @Test
    @DisplayName("차 이름 받는 로직 테스트")
    void inputCarNames() {
        InputStream readLine = new ByteArrayInputStream("pobi,woni,jun".getBytes());
        System.setIn(readLine);

        String[] expect = new String[]{"pobi", "woni", "jun"};
        String[] actual = inputView.inputCarNames();

        Assertions.assertThat(actual).isEqualTo(expect);
    }

    @Test
    @DisplayName("차 이름 받는 로직 중 이름이 5자 초과인 로직 확인")
    void inputCarNamesThrowError() {
        InputStream readLine = new ByteArrayInputStream("pobiee2,aaa,bbb".getBytes());
        System.setIn(readLine);
        Assertions.assertThatThrownBy(() -> inputView.inputCarNames())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void inputTryNumber() {
    }
}