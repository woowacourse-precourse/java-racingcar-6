package racingcar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PrinterTest {
    private static OutputStream outputMessage;
    private Printer printer;
    private List<Car> carList;

    @BeforeEach
    void setUp() {
        outputMessage = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputMessage));

        printer = new Printer();

        carList = new ArrayList<>();
        carList.add(new Car("apple"));
        carList.add(new Car("pear"));
        carList.add(new Car("melon"));

        carList.get(0).move(true);
        carList.get(0).move(true);
        carList.get(0).move(true);

        carList.get(1).move(true);
        carList.get(1).move(true);
        carList.get(1).move(true);

        carList.get(2).move(true);
    }

    @AfterEach
    void restoresStreams() {
        System.setOut(System.out);
    }

    @Test
    void printDistance_메소드에_전달된_자동차들의_거리를_출력() {
        printer.printDistance(carList);
        String expectMessage = "apple : ---" + System.lineSeparator()
                + "pear : ---" + System.lineSeparator()
                + "melon : -" + System.lineSeparator();
        assertThat(expectMessage).isEqualTo(outputMessage.toString());
    }

    @Test
    void printWinner_메소드에_전달된_우승자들의_이름을_출력() {
        carList.remove(2);
        printer.printWinner(carList);
        String expectMessage = "apple, pear";
        assertThat(expectMessage).isEqualTo(outputMessage.toString());
    }
}