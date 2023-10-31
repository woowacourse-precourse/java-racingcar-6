package racingcar.view;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest {

    @Test
    void 자동차_이름_입력_테스트() {
        // Given
        String input = "pobi,woni,jun";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // When
        InputView inputView = new InputView();
        String carNames = inputView.readCarName();

        // Then
        assertThat(input).isEqualTo(carNames);
    }
}