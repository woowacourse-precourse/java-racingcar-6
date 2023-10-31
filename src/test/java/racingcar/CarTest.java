package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarTest {

    OutputStream captor;

    @BeforeEach
    protected final void init() {
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    @Test
    void car_객체_생성하기() {
        //when
        String carName = "good";
        Car car = new Car(carName);

        //then
        assertThat(car.getName()).isEqualTo(carName);
        assertThat(car.getProgress()).isBlank();
    }

    @Test
    void car_랜덤_슷자가_기준값_이상이면_전진한다() {
        //given
        String carName = "good";
        Car car = new Car(carName);

        //when
        car.execute(4, 4);

        //then
        assertThat(car.getProgress()).isEqualTo("-");
    }

    @Test
    void car_랜덤_슷자가_기준값_미만이면_전진하지_않는다() {
        //given
        String carName = "good";
        Car car = new Car(carName);

        //when
        car.execute(4, 3);

        //then
        assertThat(car.getProgress()).isBlank();
    }

    @Test
    void car_실행_결과_출력하기() {
        //given
        String carName = "good";
        Car car = new Car(carName);
        car.execute(4, 5);

        //when
        car.showProgress();

        //then
        assertThat(output()).contains(String.format("%s : -", carName));
    }

    private String output() {
        return captor.toString().trim();
    }
}