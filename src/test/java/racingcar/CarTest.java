package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarTest {

    private Car car;

    @BeforeEach
    @Test
    void 자동차_생성() {
        car = new Car("woowacourse");

        assertThat(car.name).isEqualTo("woowacourse");
        assertThat(car.location).isEqualTo(0);
    }

    @Test
    void 자동차_이동가능여부에_따른_위치변경() {

        car.move(false);
        assertThat(car.location).isEqualTo(0);

        car.move(true);
        assertThat(car.location).isEqualTo(1);

        car.move(false);
        assertThat(car.location).isEqualTo(1);
    }

    @Test
    void 자동차의_현재_위치_출력하기() {

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        car.printProgress();
        assertThat(out.toString()).isEqualTo("woowacourse : \n");

        car.move(true);
        out.reset();

        car.printProgress();
        assertThat(out.toString()).isEqualTo("woowacourse : -\n");
    }

}
