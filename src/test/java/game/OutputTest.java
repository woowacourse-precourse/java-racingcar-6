package game;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.ConsoleOutput;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OutputTest {
    ConsoleOutput consoleOutput = new ConsoleOutput();
    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void 실행_시_자동차_이름_입력_메시지_출력() {
        consoleOutput.printCarNameInput();
        // 프로그램이 출력한 메시지 확인
        String expectedMessage = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
        assertEquals(expectedMessage, outContent.toString().trim());
    }

    @Test
    void 시도할_횟수_받을_출력_메시지() {
        consoleOutput.printAttemptsInput();

        String expectedMessage = "시도할 회수는 몇회인가요?";
        assertEquals(expectedMessage, outContent.toString().trim());
    }

    @Test
    void 실행_결과_출력_메시지() {
        List<String> cars = new ArrayList<>();
        List<String> forward = new ArrayList<>();

        cars.add("aaa");
        cars.add("bbb");
        cars.add("ccc");

        forward.add("--");
        forward.add("---");
        forward.add("----");

        consoleOutput.printForward(cars, forward);

        String expectedMessage = "aaa : --\nbbb : ---\nccc : ----";
        assertEquals(expectedMessage, outContent.toString().trim());
    }

    @Test
    void 최종_우승자_출력_메시지() {
        String winners = "aaa, bbb";
        consoleOutput.printWinners(winners);
        String expectedMessage = "최종 우승자 : aaa, bbb";
        assertEquals(expectedMessage, outContent.toString().trim());
    }
}
