package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class RaceResultsPresenterTest {

    @Test
    public void testPrintRaceProcess() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        RaceResultsPresenter racePrinter = new RaceResultsPresenter();

        List<Car> cars = new ArrayList<>();
        cars.add(new Car("pobi", new RandomNumberGenerator(), 1));
        cars.add(new Car("woni", new RandomNumberGenerator(), 2));
        cars.add(new Car("jun", new RandomNumberGenerator(), 1));

        racePrinter.printRaceProcess(cars);

        String expectedOutput = "pobi : -\r\nwoni : --\r\njun : -\r\n\r\n";
        assertEquals(expectedOutput, outputStream.toString());
    }
}