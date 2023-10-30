package racingcar;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.view.RacingView;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RacingViewTest {
    private RacingView view;
    private InputStream originalIn;
    private OutputStream originalOut;

    @BeforeEach
    void setUp() {
        view = new RacingView();
        originalIn = System.in;
        originalOut = System.out;
    }

    @AfterEach
    void restoreIn() {
        System.setIn(originalIn);
        System.setOut((PrintStream) originalOut);
        Console.close();
    }

    @Test
    void getCarListInput_테스트() {
        String input = "test";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        String result = view.getCarListInput();

        assertEquals(input, result);
    }

    @Test
    void getAttemptInput_테스트() {
        String input = "5";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        String result = view.getAttemptInput();

        assertEquals(input, result);
    }

    @Test
    void printRacingStartMessage_테스트() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        view.printRacingStartMessage();

        assertEquals("실행 결과", out.toString().trim());
    }

    @Test
    void printWinners_테스트() {
        List<String> input = Arrays.asList("red", "green");
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        view.printWinners(input);

        assertThat(out.toString().trim()).contains("최종 우승자 : ").contains("red").contains("green");
    }

    @Test
    void printProgress_테스트() {
        Map<String, Integer> input = new HashMap<>();
        input.put("red", 3);
        input.put("green", 2);
        input.put("blue", 6);

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        view.printProgress(input);

        assertThat(out.toString())
                .contains("red : ---")
                .contains("green : --")
                .contains("blue : ------");
    }

    @Test
    void printCarListInputMessage_테스트() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        view.printCarListInputMessage();

        assertEquals("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)", out.toString().trim());
    }

    @Test
    void printAttemptInputMessage_테스트() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        view.printAttemptInputMessage();

        assertEquals("시도할 횟수는 몇회인가요?", out.toString().trim());
    }
}
