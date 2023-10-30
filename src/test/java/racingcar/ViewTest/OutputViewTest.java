package racingcar.ViewTest;

import org.junit.jupiter.api.Test;
import racingcar.Model.Car;
import racingcar.View.OutputView;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OutputViewTest {

    @Test
    public void testPrintRoundResult() {
        Car car1 = new Car("tico",3);
        Car car2 = new Car("ray",5);

        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);


        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        OutputView.printRoundResult(cars);

        assertThat(outContent.toString()).contains("tico : ---","ray : -----");
    }

    @Test
    public void testPrintWinners() {
        List<String> winners = Arrays.asList("Car1", "Car2");

        String expectedOutput = "최종 우승자 : Car1, Car2";

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        OutputView.printWinners(winners);

        assertThat(outContent.toString()).contains(expectedOutput);
    }
}
