package racingcar.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.CarList;
import racingcar.domain.Winners;
import racingcar.view.OutputView;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OutputViewTest {
    private OutputView outputView;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        outputView = new OutputView();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void testPrintNameAndDistance() {
        Car car = new Car("Car1");
        car.move();
        car.move();

        String expectedOutput = "Car1 : --\n";

        outputView.printNameAndDistance(car);

        Assertions.assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void testPrintDistance() {
        int distance = 4;

        String expectedOutput = "----";

        String actualOutput = outputView.printDistance(distance);

        Assertions.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testPrintWinners() {
        Winners winners = new Winners(Collections.singletonList(new Car("Car 1")));

        String expectedOutput = "최종 우승자 : Car 1\n";

        outputView.printWinners(winners);

        Assertions.assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void testJoin() {
        List<String> input = Arrays.asList("Car 1", "Car 2", "Car 3");

        String expectedOutput = "Car 1, Car 2, Car 3";

        String actualOutput = outputView.join(input);

        Assertions.assertEquals(expectedOutput, actualOutput);
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }
}

