package racingcar;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RaceViewTest {
    private RaceView view;
    private InputStream originalIn;

    @BeforeEach
    void setUp() {
        view = new RaceView();
        originalIn = System.in;
    }

    @AfterEach
    void restoreIn() {
        System.setIn(originalIn);
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
}
