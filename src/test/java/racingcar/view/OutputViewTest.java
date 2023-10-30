package racingcar.view;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest {

    private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    @Test
    void 출력_메시지_확인() {
        // Given
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        OutputView outputView = new OutputView();

        // When
        outputView.printInputCarNameMessage();

        // Then
        assertThat(out.toString().trim()).isEqualTo(INPUT_CAR_NAME_MESSAGE);
    }
}