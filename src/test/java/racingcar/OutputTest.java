package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OutputTest {
    final ByteArrayOutputStream out = new ByteArrayOutputStream();
    final PrintStream standardOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(out));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void 한_차의_전진한_횟수를_형식에_맞게_출력() {
        String expected = "a : ---";

        OutputView.printCarMovement("a", 3);

        assertThat(out.toString()).contains(expected);
    }

    @Test
    void 모든_차의_전진한_횟수를_형식에_맞게_출력() {
        Car car = new Car("a,b");
        RacingCarGameConsole racingCarGameConsole = new RacingCarGameConsole(car, 1);

        racingCarGameConsole.race();

        assertThat(out.toString()).contains("실행 결과", "a : ", "b : ");
    }

    @Test
    void 승자를_출력() {
        List<String> winnerList = List.of("a");

        OutputView.printResult(winnerList);

        assertThat(out.toString()).contains("최종 우승자 : a");
    }

    @Test
    void 승자를_두명_출력() {
        List<String> winnerList = List.of("a", "b");

        OutputView.printResult(winnerList);

        assertThat(out.toString()).contains("최종 우승자 : a, b");
    }
}