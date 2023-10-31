package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import racingcar.constant.IllegalArgumentExceptionType;

class InputViewTest {

    InputView inputView = new InputView();

    void setUp(String[] args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

    @AfterEach
    void tearDown() {
        Console.close();
    }


    @Test
    void 차량이름_입력_성공_테스트() {
        String[] args = new String[]{"pobi, real, what"};
        setUp(args);
        assertThat(inputView.readCarNames())
                .containsExactly("pobi", "real", "what")
                .isInstanceOf(List.class)
                .hasSize(3);
    }

    @Test
    void 시도횟수_입력_성공_테스트() {
        String[] args = new String[]{"3"};
        setUp(args);

        assertThat(inputView.readAttemptCount()).isEqualTo(3);
    }
    @Test
    void 시도횟수_입력_실패_테스트() {
        IllegalArgumentException exception = IllegalArgumentExceptionType
                .PARSE_INT_ERROR_MESSAGE
                .getException();

        String[] args = new String[]{"삼"};
        setUp(args);

        assertThatThrownBy(() -> inputView.readAttemptCount())
                .isInstanceOf(exception.getClass())
                .hasMessage(exception.getMessage());
    }
}


