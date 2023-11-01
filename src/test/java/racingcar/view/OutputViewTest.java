package racingcar.view;

import java.util.ArrayList;
import java.util.List;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

public class OutputViewTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final OutputView outputView = new OutputView();

    @Test
    void printSoloWinnerTest(){
        Car car1 = new Car("car1",1);
        Car car2 = new Car("car2",2);
        Car car3 = new Car("car3",3);

        List<Car> cars= new ArrayList<>();

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        System.setOut(new PrintStream(outputStream));
        outputView.displayWinner(cars);
        String expectedOutput = "최종 우승자 : car3";

        Assertions.assertThat(expectedOutput).isEqualTo(outputStream.toString().trim());
    }

    @Test
    void printWinnersTest(){
        Car car1 = new Car("car1",1);
        Car car2 = new Car("car2",2);
        Car car3 = new Car("car3",2);
        Car car4 = new Car("car4",1);

        List<Car> cars= new ArrayList<>();

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);

        System.setOut(new PrintStream(outputStream));
        outputView.displayWinner(cars);
        String expectedOutput = "최종 우승자 : car2,car3";

        Assertions.assertThat(expectedOutput).isEqualTo(outputStream.toString().trim());
    }
}
