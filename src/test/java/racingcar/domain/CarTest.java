package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    void 자동차_전진여부_확인() {
        //given
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");

        //when
        car1.moveForward(4);
        car2.moveForward(2);

        //then
        assertThat(car1.getPosition() == 1);
        assertThat(car2.getPosition() == 0);
    }

    @Test
    public void 자동차_출력_확인() throws Exception {
        //given
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Car car = new Car("car");

        //when
        car.moveForward(4);
        car.displayPosition();

        //then
        assertThat(outContent.toString().trim()).isEqualTo("car : -");
    }

}
