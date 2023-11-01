package racingcar.view;

import static org.junit.jupiter.api.Assertions.*;
import static racingcar.domain.Car.createCar;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

class OutputViewTest {
    OutputView outputView = new OutputView();
    Car car1 = createCar("car A", 2);
    Car car2 = createCar("car B", 2);
    Car car3 = createCar("car C", 2);
    List<Car> cars = List.of(car1, car2, car3);

    private static OutputStream out;
    @BeforeEach
    void beforeSetup() {
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @DisplayName("회차별 진행 상황을 출력한다.")
    @Test
    void testPrintAttempResult() {
        outputView.printAttempResult(cars);

        String expectedResult = "car A : --\ncar B : --\ncar C : --";
        assertEquals(expectedResult, out.toString().trim());
    }

    @DisplayName("최종 우승자를 출력한다.")
    @Test
    void testPrintWinners() {
        outputView.printWinners(cars);

        String expectedResult = "최종 우승자 : car A, car B, car C";
        assertEquals(expectedResult, out.toString().trim());
    }
}