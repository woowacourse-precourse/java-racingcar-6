package racingcar.view;

import static org.junit.jupiter.api.Assertions.*;
import static racingcar.domain.Car.createCar;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

class OutputViewTest {
    OutputView outputView = new OutputView();

    @Test
    void testPrintAttempResult() {
        Car car1 = createCar("car A",2);
        Car car2 = createCar("car B",2);
        Car car3 = createCar("car C",2);
        List<Car> cars = List.of(car1, car2, car3);

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        outputView.printAttempResult(cars);

        assertEquals("car A : --\ncar B : --\ncar C : --\n\n",out);

    }

    @Test
    void testPrintWinners() {
        Car car1 = createCar("car A",2);
        Car car2 = createCar("car B",2);
        Car car3 = createCar("car C",2);
        List<Car> cars = List.of(car1, car2, car3);

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        outputView.printWinners(cars);

        assertEquals("최종 우승자 : car A, car B, car C\n",out);
    }
}