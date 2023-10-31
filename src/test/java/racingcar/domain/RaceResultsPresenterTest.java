package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RaceResultsPresenterTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    public void setSystemOut() {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void testPrintRaceProcess() {
        RaceResultsPresenter racePrinter = new RaceResultsPresenter();

        List<Car> cars = createTestCars();
        racePrinter.printRaceProcess(cars);

        String expectedOutput = "pobi : -\r\nwoni : --\r\njun : -\r\n\r\n";
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void testPrintWinner() {
        RaceResultsPresenter racePrinter = new RaceResultsPresenter();
        List<Car> cars = createTestCars();
        racePrinter.printWinner(cars);

        String expectedOutput = "최종 우승자 : woni\r\n";
        assertEquals(expectedOutput, outputStream.toString());
    }

    private List<Car> createTestCars() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("pobi", new RandomNumberGenerator(), 1));
        cars.add(new Car("woni", new RandomNumberGenerator(), 2));
        cars.add(new Car("jun", new RandomNumberGenerator(), 1));
        return cars;
    }
}
