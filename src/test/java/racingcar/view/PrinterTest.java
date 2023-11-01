package racingcar.view;



import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import racingcar.model.Car;


public class PrinterTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    Printer printer;


    public void preset() {
        System.setOut(new PrintStream(outContent));
        printer =Printer.getInstance();
    }


    @Test
    public void testPrintRoundState() {
        preset();
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("Car1"));
        carList.add(new Car("Car2"));
        carList.add(new Car("Car3"));

        carList.get(0).move(1);
        carList.get(1).move(2);
        carList.get(2).move(3);

        printer.printRoundState(carList);

        String expectedOutput = "Car1 : -\nCar2 : --\nCar3 : ---\n\n";

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testPrintSoloWinner() {
        preset();

        List<Car> winners = new ArrayList<>();
        winners.add(new Car("pobi"));

        printer.printResult(winners);

        String expectedOutput = "최종 우승자 : pobi\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testPrintMultiWinner() {
        preset();
        List<Car> winners = new ArrayList<>();
        winners.add(new Car("pobi"));
        winners.add(new Car("woni"));
        winners.add(new Car("jun"));

        printer.printResult(winners);

        String expectedOutput = "최종 우승자 : pobi, woni, jun";
        assertEquals(expectedOutput, outContent.toString());
    }


}

