package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

class InputViewTest {

    @Test
    void 자동차_이름_입력_테스트() {
        // Given
        String input = "pobi,woni,jun";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // When
        InputView inputView = new InputView();
        String carNames = inputView.readRacersName();

        // Then
        assertThat(input).isEqualTo(carNames);
    }
}