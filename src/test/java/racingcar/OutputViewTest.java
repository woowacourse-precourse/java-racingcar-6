package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.model.Cars;
import racingcar.view.OutputView;

public class OutputViewTest {


    private final OutputView outputView = new OutputView();

    @Test
    public void printPosition_함수_테스트() {

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        OutputView outputView = new OutputView();

        Cars cars = Cars.makeCarList(List.of("car1", "car2"));
        outputView.printCarsPosition(cars);

        String actualOutput = outputStream.toString();
        String expectedOutput1 = "car1 : ";
        String expectedOutput2 = "car2 : ";

        assertThat(actualOutput).contains(expectedOutput1);
        assertThat(actualOutput).contains(expectedOutput2);

        System.setOut(System.out);
    }


    @Test
    public void printWinners_함수_테스트() {

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        OutputView outputView = new OutputView();

        Cars cars = Cars.makeCarList(List.of("car1", "car2"));
        outputView.printWinners(cars);

        String actualOutput = outputStream.toString();
        String expectedOutput1 = "car1, car2";

        assertThat(actualOutput).contains(expectedOutput1);
        System.setOut(System.out);
    }
}
