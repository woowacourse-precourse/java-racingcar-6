package racingcar.view;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest {

    @Test
    void 실행_결과_출력() {
        // given
        Car carA = Car.of("Car A");
        carA.moveForward();
        carA.moveForward();
        Car carB = Car.of("Car B");
        carB.moveForward();
        List<Car> cars = List.of(carA, carB);

        // when
        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        OutputView.printRaceResult(cars);

        // then

        assertThat(outputStream.toString().trim()).contains("Car A", "Car B", "--");
    }
}