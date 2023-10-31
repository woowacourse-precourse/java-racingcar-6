package racingcar.game;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.utils.GameUtils;

class CarTest {

    OutputStream captor;

    @BeforeEach
    void init() {
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    @Test
    void 자동차_이름으로_car_객체를_생성한다() {
        //given
        String carName = "good";

        //when
        Car car = Car.of(carName, GameUtils.INITIAL_PROGRESS);

        //then
        assertThat(car.getName()).isEqualTo(carName);
        assertThat(car.getProgress()).isBlank();
    }

    @Test
    void car_랜덤_슷자가_기준값_이상이면_전진한다() {
        //given
        String carName = "good";
        String command = "-";
        Car car = Car.of(carName, GameUtils.INITIAL_PROGRESS);

        //when
        car.forward(4, 4, command);

        //then
        assertThat(car.getProgress()).containsOnlyOnce(command);
    }

    @Test
    void car_랜덤_슷자가_기준값_미만이면_전진하지_않는다() {
        //given
        String carName = "good";
        String command = "-";

        Car car = Car.of(carName, GameUtils.INITIAL_PROGRESS);

        //when
        car.forward(4, 3, command);

        //then
        assertThat(car.getProgress()).isBlank();
    }

    @Test
    void car_실행_결과_출력하기() {
        //given
        String carName = "good";
        String command = "-";

        Car car = Car.of(carName, GameUtils.INITIAL_PROGRESS);
        car.forward(4, 5, command);

        //when
        car.showProgress();

        //then
        assertThat(output()).contains(String.format("%s : %s", carName, command));
    }

    private String output() {
        return captor.toString().trim();
    }
}