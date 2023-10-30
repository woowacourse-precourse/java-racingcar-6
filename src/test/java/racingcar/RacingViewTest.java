package racingcar;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.view.RacingView;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RacingViewTest {
    private RacingView view;
    private InputStream originalIn;
    private PrintStream originalOut;

    @BeforeEach
    void setUp() {
        view = new RacingView();
        originalIn = System.in;
        originalOut = System.out;
    }

    @AfterEach
    void restoreIn() {
        System.setIn(originalIn);
        System.setOut(originalOut);
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
}
