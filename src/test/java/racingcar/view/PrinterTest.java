package racingcar.view;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import racingcar.model.Car;


public class PrinterTest {
    String name1 = "pobi";
    String name2 = "woni";
    String name3 = "jun";
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    Printer printer;


    public void beforeEach() {
        System.setOut(new PrintStream(outContent));
        printer = Printer.getInstance();
    }

    public void afterEach() {
        System.setOut(originalOut);
    }


    @Test
    public void testPrintRoundState() {
        beforeEach();
        List<Car> carList = new ArrayList<>();
        carList.add(new Car(name1));
        carList.add(new Car(name2));
        carList.add(new Car(name3));

        carList.get(0).move(1);
        carList.get(1).move(2);
        carList.get(2).move(3);

        printer.printRoundState(carList);

        String expectedOutput = name1 + " : -\n" + name2 + " : --\n" + name3 + " : ---\n\n";

        assertEquals(expectedOutput, outContent.toString());

        afterEach();
    }

    @Test
    public void testPrintSoloWinner() {
        beforeEach();

        List<Car> winners = new ArrayList<>();
        winners.add(new Car(name1));

        printer.printResult(winners);

        String expectedOutput = "최종 우승자 : " + name1 + "\n";
        assertEquals(expectedOutput, outContent.toString());

        afterEach();
    }

    @Test
    public void testPrintMultiWinner() {
        beforeEach();
        List<Car> winners = new ArrayList<>();
        winners.add(new Car(name1));
        winners.add(new Car(name2));

        printer.printResult(winners);

        String expectedOutput = "최종 우승자 : " + name1 + ", " + name2;
        assertEquals(expectedOutput, outContent.toString());

        afterEach();
    }
}

