package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.Test;

class InputViewTest {

    InputView inputView = InputView.getInstance();

    @Test
    void 시도_횟수_입력_후_조건_일치하면_정수로_변환_후_반환() {
        String input = "123";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        int tryNumber = inputView.InputTryNumber();
        assertThat(tryNumber).isEqualTo(123);
    }
}