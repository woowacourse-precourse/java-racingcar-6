package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OutputTest {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;

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
        GameConsole gameConsole = new GameConsole(car, "1");

        gameConsole.race();

        assertThat(out.toString()).contains("실행 결과", "a : ", "b : ");
    }

    @Test
    void 전진한_횟수_출력을_입력_횟수만큼_반복() {
        Car car = new Car("a,b");
        String timesToTry = "3";
        GameConsole gameConsole = new GameConsole(car, timesToTry);

        gameConsole.race();

        assertThat(out.toString().split("실행 결과", -1))
                .hasSize(Integer.parseInt(timesToTry) + 1);
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