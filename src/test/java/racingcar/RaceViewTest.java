package racingcar;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RaceViewTest {
    private RaceView view;
    private InputStream originalIn;
    private PrintStream originalOut;

    @BeforeEach
    void setUp() {
        view = new RaceView();
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
    void printWinners_테스트() {
        List<String> input = Arrays.asList("red", "green", "blue");
        List<Car> carList = RacingUtil.createCarsFromNames(input);
        OutputStream stream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(stream));

        view.printWinners(carList);

        assertThat(stream.toString()).contains("최종 우승자", "red", "green", "blue");
    }

    @Test
    void printProgress_테스트() {
        List<String> input = Arrays.asList("red", "green", "blue");
        List<Car> carList = RacingUtil.createCarsFromNames(input);
        OutputStream stream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(stream));

        carList.get(0).move();
        carList.get(0).move();
        view.printProgress(carList);

        assertThat(stream.toString()).contains("red : --");
    }
}
