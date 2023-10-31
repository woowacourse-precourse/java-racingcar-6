package racingcar.view;


import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputViewTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    private InputView inputView;


    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        inputView = new InputView();
    }

    @DisplayName("자동차 이름 입력 요청을 올바르게 출력하는지 확인")
    @Test
    public void testPrintCarNameRequest() {
        try {
            inputView.printCarNameRequest();
        } catch (Exception ignored) {
        }
        assertThat(outContent.toString().trim()).isEqualTo("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @DisplayName("시도 횟수 입력 요청을 올바르게 출력하는지 확인")
    @Test
    public void testPrintAttemptCountRequest() {
        try {
            inputView.printAttemptCountRequest();
        } catch (Exception ignored) {
        }
        assertThat(outContent.toString().trim()).isEqualTo("시도할 회수는 몇회인가요?");
    }

    @org.junit.jupiter.api.AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }
}

