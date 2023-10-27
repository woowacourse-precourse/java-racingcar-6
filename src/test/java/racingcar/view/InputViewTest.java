package racingcar.view;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputViewTest {
    private final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;
    private final InputView inputView = new InputView();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(byteArrayOutputStream));
    }

    @Test
    @DisplayName("자동차 입력 문구 출력 테스트")
    public void testInputCarsMessage() {
        inputView.printInputCarsNameMessage();
        String output = byteArrayOutputStream.toString();

        Assertions.assertThat(output.trim()).isEqualTo("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @Test
    @DisplayName("시도 횟수 입력 문구 출력 테스트")
    public void testInputAttemptCountMessage() {
        inputView.printInputTotalRoundMessage();
        String output = byteArrayOutputStream.toString();

        Assertions.assertThat(output.trim()).isEqualTo("시도할 회수는 몇회인가요?");
    }

    @Test
    @DisplayName("시도 횟수에 숫자가 아닌 값 입력 시 테스트")
    public void testInputTotalRoundNotNumeric() {
        InputStream readLine = setReadLine("abc");
        System.setIn(readLine);

        org.junit.jupiter.api.Assertions.assertThrows(IllegalArgumentException.class, inputView::totalRound);
    }

    private InputStream setReadLine(String readLine) {
        return new ByteArrayInputStream(readLine.getBytes());
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }
}
