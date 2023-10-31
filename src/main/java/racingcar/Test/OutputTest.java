package racingcar.Test;

import racingcar.View.OutputView;
import racingcar.Computer.RaceManager;
import racingcar.Car.Car;

import org.junit.jupiter.api.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;


import java.util.Collections;
import java.util.List;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;



public class OutputTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        outputStream.reset();
        System.setOut(new PrintStream(outputStream));
    }
    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    @DisplayName("생성한 자동차들이 출력되는지 확인")
    void testAllCarsAreDisplayed() {
        List<Car> testCars = Arrays.asList(new Car("car1"), new Car("car2"));
        OutputView.printCars(testCars);
        String capturedOutput = outputStream.toString();
        assertTrue(capturedOutput.contains("car1"));
        assertTrue(capturedOutput.contains("car2"));
    }

    @Test
    @DisplayName("시도한 횟수만큼 경주가 출력되는지 확인")
    void testRaceProgress() {
        List<Car> testCars = Collections.singletonList(new Car("car1"));
        int testRepeatCount = 5;
        RaceManager raceManager = new RaceManager(testCars, testRepeatCount);
        raceManager.startRace();

        String capturedOutput = outputStream.toString();
        String carName = "car1";

        long actualCount = capturedOutput.lines()
                .filter(line -> line.contains(carName))
                .count();

        assertThat(actualCount).isEqualTo(testRepeatCount);
    }

    @Test
    @DisplayName("자동차 위치 값만큼 출력 확인")
    void testCarPositionOutput() {
        Car car = new Car("car1");
        car.move(3);

        List<Car> testCars = Collections.singletonList(car);
        OutputView.printCars(testCars);
        String capturedOutput = outputStream.toString();

        String expectedOutput = "car1 : ---";

        assertTrue(capturedOutput.contains(expectedOutput));
    }

    @Test
    @DisplayName("위치 값이 0일 경우 비워 두는지 확인")
    void testEmptyOutputForZeroPosition() {
        Car car = new Car("car1");
        car.move(0);

        List<Car> testCars = Collections.singletonList(car);
        OutputView.printCars(testCars);
        String capturedOutput = outputStream.toString();

        String expectedOutput = "car1 :";

        assertTrue(capturedOutput.contains(expectedOutput));
    }

    @Test
    @DisplayName("마지막에 우승자 출력 확인")
    void testWinnerOutput() {
        Car winnerCar = new Car("car1");
        List<Car> winners = Collections.singletonList(winnerCar);

        OutputView.printWinners(winners);

        String capturedOutput = outputStream.toString();
        String expectedOutput = "최종 우승자 : car1";
        assertTrue(capturedOutput.contains(expectedOutput));
    }
    @Test
    @DisplayName("공동우승자 출력 확인")
    void testJointWinnerOutput() {
        List<Car> winners = Arrays.asList(new Car("car1"), new Car("car2"));
        OutputView.printWinners(winners);

        String capturedOutput = outputStream.toString();
        String expectedOutput = "최종 우승자 : car1, car2";
        assertTrue(capturedOutput.contains(expectedOutput));
    }
}
