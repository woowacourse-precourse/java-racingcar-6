package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    void Car_객체_생성_테스트() {
        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Car car = new Car("testCar");
        car.updatePosition();
        car.updatePosition();
        car.updatePosition();
        System.out.print(car.getName() + " : " + car.process());
        assertThat(outputStream.toString()).isEqualTo("testCar : ---");
    }
}
