package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.Test;

class InputViewTest {

    @Test
    void 쉼표_구분_자동차_이름_문자열_입력_List_반환() {
        String input = "a,b,c";
        InputStream readLine = setReadLine(input);
        System.setIn(readLine);

        List<String> actual = InputView.inputCars();

        assertThat(actual).containsExactly("a", "b", "c");
    }

    @Test
    void 시행_횟수_입력_int_반환() {
        String input = "5";
        InputStream readLine = setReadLine(input);
        System.setIn(readLine);

        int actual = InputView.inputTurn();

        assertThat(actual).isEqualTo(5);
    }

    public static InputStream setReadLine(String readLine) {
        return new ByteArrayInputStream(readLine.getBytes());
    }
}
