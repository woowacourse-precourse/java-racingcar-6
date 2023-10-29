package racingcar.view;

import static org.junit.jupiter.api.Assertions.*;
import static racingcar.view.OutputView.printAttempResult;
import static racingcar.view.OutputView.printWinners;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

class OutputViewTest {

    @Test
    void testPrintAttempResult() {
        Car car1 = new Car("car A",2);
        Car car2 = new Car("car B",2);
        Car car3 = new Car("car C",2);
        List<Car> cars = List.of(car1, car2, car3);

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        printAttempResult(cars);

        assertEquals("car A : --\ncar B : --\ncar C : --\n\n",out);

    }

    @Test
    void testPrintWinners() {
        Car car1 = new Car("car A",2);
        Car car2 = new Car("car B",2);
        Car car3 = new Car("car C",2);
        List<Car> cars = List.of(car1, car2, car3);

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        printWinners(cars);

        assertEquals("최종 우승자 : car A, car B, car C\n",out);
    }
}