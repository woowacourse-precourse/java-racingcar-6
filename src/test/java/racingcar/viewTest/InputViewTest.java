package racingcar.viewTest;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.view.InputView;

public class InputViewTest {

    private InputView inputView;
    private OutputStream outputStream;

    @BeforeEach
    void setUp() {
        inputView = new InputView();
        outputStream = new ByteArrayOutputStream();
    }

    @DisplayName("게임 시작 메세지가 정상적으로 출력되는지 확인한다.")
    @Test
    void showGameStartMessage() {
        String expected = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

        System.setOut(new PrintStream(outputStream));

        inputView.showGameStartMessage();
        Assertions.assertEquals(expected, outputStream.toString().trim());
    }

    @DisplayName("시도할 횟수 입력 메세지가 정상적으로 출력되는지 확인한다.")
    @Test
    void showTrialMessage() {
        String expected = "시도할 회수는 몇회인가요?";
        System.setOut(new PrintStream(outputStream));

        inputView.showTrialNumberInputMessage();
        Assertions.assertEquals(expected, outputStream.toString().trim());
    }
}
