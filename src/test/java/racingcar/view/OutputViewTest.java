package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.view.OutputView;

public class OutputViewTest {
    OutputView outputView;

    @BeforeEach
    public void setUp() {
        outputView = new OutputView();
    }

    @DisplayName("자동차 이름 입력 요청 메세지 출력 기능 테스트")
    @Test
    void testRequestCarNamesMessage() {
        String expected = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n";
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        outputView.requestCarNamesMessage();
        System.setOut(System.out);

        assertEquals(expected, outputStream.toString());
    }
}
