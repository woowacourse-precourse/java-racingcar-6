package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class DomainTest {
    private static final int ROUND = 5;

    private OutputStream outputStream;

    @BeforeEach
    void initStream() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void Car_객체_생성_테스트() {
        Car car = new Car("testCar");
        car.updatePosition();
        car.updatePosition();
        car.updatePosition();
        System.out.print(car.getName() + " : " + car.process());
        assertThat(outputStream.toString()).isEqualTo("testCar : ---");
    }

    @Test
    void Cars_객체_생성_테스트() {
        Cars cars = new Cars("pobi,woni,jun");
        cars.roundStatus(ROUND);
        Assertions.assertThat(outputStream.toString()).isNotNull();
    }
}
