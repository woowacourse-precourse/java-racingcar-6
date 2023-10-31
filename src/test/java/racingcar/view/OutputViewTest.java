package racingcar.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest {

    private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_MOVE_NUMBER_MESSAGE = "시도할 회수는 몇회인가요?";

    @Test
    void 출력_메시지_확인() {
        // Given
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        OutputView outputView = new OutputView();

        // When
        outputView.printInputRacersNameMessage();

        // Then
        assertThat(out.toString().trim()).isEqualTo(INPUT_CAR_NAME_MESSAGE);
    }

    @Test
    void 반복_횟수_출력_메시지_확인() {
        // Given
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        OutputView outputView = new OutputView();

        // When
        outputView.printInputMoveNumberMessage();

        // Then
        assertThat(out.toString().trim()).isEqualTo(INPUT_MOVE_NUMBER_MESSAGE);
    }
}