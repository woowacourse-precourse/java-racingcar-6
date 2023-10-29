package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class InputViewTest {

    private final InputStream originalSystemIn = System.in;

    @AfterEach
    public void restoreSystemInStream() {
        System.setIn(originalSystemIn);
    }

    @Test
    void 사용자입력테스트() {
        ByteArrayInputStream inContent = new ByteArrayInputStream("car1,car2,car3\n".getBytes());
        System.setIn(inContent);
        String input = InputView.inputCarNames();
        assertThat(input).isEqualTo("car1,car2,car3");
    }
}
