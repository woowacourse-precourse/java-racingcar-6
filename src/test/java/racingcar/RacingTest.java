package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

class RacingTest {

    private User user;
    private Racing racing;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        user = new User();
        racing = new Racing(user);
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void checkStopAndGo_4이상_이동() {
        provideInput("car1\n1\n");
        user.input();

        racing.checkStopAndGo();
        assertThat(user.getMap().get("car1")).isEqualTo(1);
    }

    @Test
    void checkStopAndGo_4이하() {
        provideInput("car1\n0\n");
        user.input();

        racing.checkStopAndGo();
        assertThat(user.getMap().get("car1")).isEqualTo(0);
    }

    @Test
    void race() {
        provideInput("car1,car2\n2\n");
        user.input();
        racing.race();

        // 프린트 출력문 캡처
        String printedOutput = outContent.toString().trim();
        // 엔터를 기준으로 위에서 캡처한 프린트문 배열에 저장
        String[] outputLines = printedOutput.split("\n");
        // 프린트문의 제일 마지막이며, 배열의 맨 마지막에 "최종 우승자"가 포함 되어있는가?
        assertThat(outputLines[outputLines.length - 1]).contains("최종 우승자");
    }

    @Test
    void showWinner() {
        provideInput("car1,car2\n1\n");
        user.input();

        user.getMap().put("car1", 1);
        user.getMap().put("car2", 0);

        racing.showWinner();

        String printedOutput = outContent.toString().trim();
        assertThat(printedOutput).contains("최종 우승자 : car1");
    }

    private void provideInput(String input) {
        InputStream test = new ByteArrayInputStream(input.getBytes());
        System.setIn(test);
    }
}