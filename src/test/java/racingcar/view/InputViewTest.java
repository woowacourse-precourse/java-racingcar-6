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
        String carNames = inputView.readRacersName();

        // Then
        assertThat(input).isEqualTo(carNames);
    }

    @Test
    void 반복_횟수_입력_테스트() {
        // Given
        String input = "5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // When
        InputView inputView = new InputView();
        int moveNumber = inputView.readMoveNumber();

        // Then
        assertThat(Integer.parseInt(input)).isEqualTo(moveNumber);
    }
}